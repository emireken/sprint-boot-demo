package com.example.demo.api.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.example.demo.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private static final String JSON_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912";

    private static final String QUERY_PARAM = "weather?units=metric&lang=en&APPID={key}";

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @Autowired
    private ParsingService parsingService;

    @Autowired
    private JsonParsingService jsonParsingService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;

    }

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    public Object getWeather() {
        //String weathers = new String(String.valueOf(parsingService.parse(JSON_WEATHER_URL + "&lat=41.04473&lon=29.0353")));
        final EObject weathers = parsingService.parse(JSON_WEATHER_URL + "&lat=41.04473&lon=29.0353");
        return weathers.getBody(). ;
    }

    @PostMapping
    public void addWeather(@Valid @NotNull @NotBlank @RequestBody Weather weather) {
        weatherService.addWeather(weather);
    }

    @GetMapping (path ="{id}")
    public Optional<Weather> getWeatherById(@PathVariable("id") Integer id){
        return weatherService.getWeatherById(id);
    }

    @DeleteMapping (path ="{id}")
    public void deleteWeatherById(@PathVariable("id") Integer id) {
        weatherService.deleteWeather(id);
    }

    @RequestMapping(path = "/lat&lon", method = RequestMethod.GET)
    public Object getWeatherByLatLon(@RequestParam (value = "lat", required = true) Double lat,
                                     @RequestParam (value = "lon", required = true) Double lon, final Model model){
        final Object weathers = parsingService.parse(JSON_WEATHER_URL + "&lat="+lat+"&lon="+lon);
        return weathers ;
    }


    @RequestMapping(path = "/lat&lon", method = RequestMethod.POST)
    public int addWeatherByLatLon(@RequestParam (value = "lat", required = true) Double lat,
                                      @RequestParam (value = "lon", required = true) Double lon, final Model model){
        Object weathers = parsingService.parse(JSON_WEATHER_URL + "&lat="+lat+"&lon="+lon);
        model.addAttribute("weathers", weathers);
        //Weather weather = getJdbcTemplate().queryForObject((String) weathers, new Object[]{}, mapWeatherFomWS());
        //Object accountList = mapper.convertValue(weathers,new TypeReference<Object>(){});
        //weatherService.addWeather(accountList);
        String sql = "INSERT INTO " +
                "weather (\"weatherId\", temperature, \"weatherMain\", \"weatherIcon\", \"weatherDescription\", \"countryCode\", name, \"timestamp\", \"sunrise\", \"sunset\") " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,new Object[]{1},mapWeatherFomWS());
    }

    private RowMapper<Object> mapWeatherFomWS() {
        return (resultSet, i) -> {
            Integer weatherId = resultSet.getInt("weather.id");
            Integer temperature = resultSet.getInt("temperature");
            String weatherMain = resultSet.getString("weather.main");
            String weatherIcon = resultSet.getString("weather.icon");
            String weatherDescription = resultSet.getString("weather.description");
            String countryCode = resultSet.getString("sys.county");
            String name = resultSet.getString("name");
            Long timestamp = resultSet.getLong("timestamp");
            Long sunrise = resultSet.getLong("sys.sunrise");
            Long sunset = resultSet.getLong("sys.sunset");

            return new Weather(weatherId, temperature, weatherMain, weatherIcon, weatherDescription, countryCode, name, timestamp, sunrise, sunset );
        };
    }
}
