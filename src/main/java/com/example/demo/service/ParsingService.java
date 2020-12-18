package com.example.demo.service;

import com.example.demo.model.Weather;

import java.util.List;

public interface ParsingService {

    Object parse(String url);

    String parseString(String url);

    List<Weather> parseWeather(String url);
}
