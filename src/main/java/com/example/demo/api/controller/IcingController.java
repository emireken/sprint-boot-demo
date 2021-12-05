//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.service.IcingService;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/icing"})
public class IcingController {
    private static final String JSON_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912";
    private final IcingService icingService;
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public IcingController(IcingService icingService) {
        this.icingService = icingService;
    }

    @RequestMapping(
            path = {"/weather"},
            method = {RequestMethod.GET}
    )
    public Object getWeather() {
        String weathers = this.parsingService.parseString("http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912&lat=41.04473&lon=29.0353");
        return weathers;
    }

    @RequestMapping(
            path = {"/icing"},
            method = {RequestMethod.GET}
    )
    public Object getIcing() {
        String weather = this.parsingService.parseString("http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912&lat=62.894884633431545&lon=-47.83492638798679");
        return this.icingService.getIcing(weather);
    }

    @RequestMapping(
            path = {"weather/lat&lon"},
            method = {RequestMethod.GET}
    )
    public Object getWeatherDataByLatLon(@RequestParam(value = "lat",required = true) Double lat, @RequestParam(value = "lon",required = true) Double lon, final Model model) {
        Object weathers = this.parsingService.parse("http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912&lat=" + lat + "&lon=" + lon);
        return weathers;
    }

    @RequestMapping(
            path = {"icing/lat&lon"},
            method = {RequestMethod.GET}
    )
    public Object getIcingDataByLatLon(@RequestParam(value = "lat",required = true) Double lat, @RequestParam(value = "lon",required = true) Double lon, final Model model) {
        String weather = this.parsingService.parseString("http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912&lat=" + lat + "&lon=" + lon);
        return this.icingService.getIcing(weather);
    }
}
