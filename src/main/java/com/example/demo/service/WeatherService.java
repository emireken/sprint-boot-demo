package com.example.demo.service;

import com.example.demo.dao.WeatherDataAccessService;
import com.example.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherDataAccessService weatherDataAccessService;


    @Autowired
    public WeatherService(WeatherDataAccessService weatherDataAccessService) {
        this.weatherDataAccessService = weatherDataAccessService;
    }

    public List<Weather> getAllWeathers(){
        return weatherDataAccessService.selectAllWeathers();
    }

    public int addWeather(Weather weather) {
        return weatherDataAccessService.insertWeather(weather);
    }

    public Optional<Weather> getWeatherById (Integer id) {
        return weatherDataAccessService.selectWeatherById(id);
    }

    public int deleteWeather(Integer id) {
        return weatherDataAccessService.deleteWeatherById(id);
    }

    public int updateWeather(Integer id, Weather newWeather) {
        return weatherDataAccessService.updateWeatherById(id, newWeather);
    }

}
