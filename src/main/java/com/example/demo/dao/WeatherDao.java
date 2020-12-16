package com.example.demo.dao;

import com.example.demo.model.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherDao {

    default int insertWeather(Weather weather){
        return  insertWeather(weather);
    }

    List<Weather> selectAllWeathers();

    Optional<Weather> selectWeatherById(Integer id);

    int deleteWeatherById(Integer id);
    int updateWeatherById(Integer id, Weather weather);

}

