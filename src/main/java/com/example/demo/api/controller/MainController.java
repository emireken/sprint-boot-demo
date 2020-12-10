package com.example.demo.api.controller;

import com.example.demo.model.Country;
import com.example.demo.service.ParsingService;
import com.example.demo.service.JsonParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/country")
public class MainController {

    private static final String JSON_COUNTRY_URL = "https://restcountries.eu/rest/v2/name/";

    @Autowired
    private ParsingService parsingService;

    @Autowired
    private JsonParsingService jsonParsingService;


    @GetMapping
    public List<Country> main( final Model model){
        List<Country> countries =  (List<Country>) parsingService.parse(JSON_COUNTRY_URL+"turkey");
        model.addAttribute("country", countries.get(0));
        return countries;
    }

    @GetMapping(path ="{name}")
    public List<Country> mainbyname(@PathVariable("name") String name, final Model model){
        List<Country> countries =  (List<Country>) parsingService.parse(JSON_COUNTRY_URL+ name );
        model.addAttribute("country", countries.get(0));
        return countries;
    }
}
