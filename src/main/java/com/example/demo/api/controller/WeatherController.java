package com.example.demo.api.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private static final String JSON_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=tr&appid=e5def15cc837a57ebd4e07827b3e8912";

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
    public String getWeather(){
        String weathers = new String(String.valueOf(parsingService.parse(JSON_WEATHER_URL + "&lat=41.04473&lon=29.0353")));
        return weathers ;
    }
    
    @GetMapping(path ="{name}")
    public List<Weather> weatherByName(@PathVariable("name") String name, final Model model){
        List<Weather> weathers =  (List<Weather>) parsingService.parse(JSON_WEATHER_URL+"name/"+ name );
        model.addAttribute("weather", weathers.get(0));
        return weathers;
    }

    @PostMapping
    public void addWeather(@Valid @NotNull @RequestBody Weather weather) {
        weatherService.addWeather(weather);
    }

    @PostMapping(path ="{name}")
    public List<Weather> addWeatherToDb(@PathVariable("name") String name, final Model model){
        List<Weather> weathers =  (List<Weather>) parsingService.parse(JSON_WEATHER_URL+"name/"+ name );
        model.addAttribute("weather", weathers.get(0));
        List<Weather> accountList = mapper.convertValue(
                weathers,
                new TypeReference<List<Weather>>(){}
        );
        weatherService.addWeather(accountList.get(0));
        return weathers;

    }

    @DeleteMapping (path ="{id}")
    public void deleteWeatherById(@PathVariable("id") Integer id) {
        weatherService.deleteWeather(id);
    }
}
