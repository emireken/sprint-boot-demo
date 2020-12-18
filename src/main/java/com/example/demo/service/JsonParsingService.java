package com.example.demo.service;

import com.example.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonParsingService implements ParsingService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url, Object.class);
    }

    @Override
    public String parseString(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public List<Weather> parseWeather(String url) {
        return restTemplate.getForObject(url, List.class);
    }
}
