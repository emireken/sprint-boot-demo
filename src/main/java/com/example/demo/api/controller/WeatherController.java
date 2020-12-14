package com.example.demo.api.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.common.base.Splitter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    public Object getWeather() {
        //String weathers = new String(String.valueOf(parsingService.parse(JSON_WEATHER_URL + "&lat=41.04473&lon=29.0353")));
        final Object weathers = parsingService.parse(JSON_WEATHER_URL + "&lat=41.04473&lon=29.0353");
        return weathers ;
    }

    @PostMapping
    public void addWeather(@Valid @NotNull @NotBlank @RequestBody Weather weather) {
        weatherService.addWeather(weather);
    }

    @RequestMapping(path = "/lat&lon", method = RequestMethod.GET)
    public Object getWeatherByLatLon(@RequestParam (value = "lat", required = true) Double lat,
                                     @RequestParam (value = "lon", required = true) Double lon, final Model model){
        final Object weathers = parsingService.parse(JSON_WEATHER_URL + "&lat="+lat+"&lon="+lon);
        return weathers ;
    }

    /*
    @RequestMapping(path = "/lat&lon", method = RequestMethod.POST)
    public String  weatherByLatLonToDb(@RequestParam (value = "lat", required = true) Double lat,
                                       @RequestParam (value = "lon", required = true) Double lon, final Model model){

        String weathers = new String(String.valueOf(parsingService.parse(JSON_WEATHER_URL+ "&lat="+lat+"&lon="+lon)));
        List<String> weathers1 = (List<String>)(Arrays.asList(weathers));
        //List<Weather> weathers2 =  (List<Weather>) parsingService.parse(weathers);
        //List<Weather> weathers =  (List<Weather>) parsingService.parse(JSON_WEATHER_URL+ "&lat="+lat+"&lon="+lon);
        //List<String> weathers1 = (List<String>)(Arrays.asList(weathers));
        //List<String> weathers1 = (List<String>) (LinkedHashMap(Arrays.asList(weathers)));
        // List<Weather> weathers2 =  (List<Weather>) parsingService.parse(weathers);

        model.addAttribute("weather", weathers);
        List<Weather> weatherList = mapper.convertValue(weathers1, new TypeReference<List<Weather>>(){});
        weatherService.addWeather(

                weatherList.get(0));
        return weathers;
    }
*/

    @DeleteMapping (path ="{id}")
    public void deleteWeatherById(@PathVariable("id") Integer id) {
        weatherService.deleteWeather(id);
    }
}
