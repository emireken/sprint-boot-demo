package com.example.demo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class WeatherMain {

    private Integer temp;
    private Integer pressure;
    private Integer humidity;


    public WeatherMain(Integer temp, Integer pressure, Integer humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}