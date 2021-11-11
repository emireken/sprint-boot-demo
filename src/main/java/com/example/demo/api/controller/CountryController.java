//package com.example.demo.api.controller;
//
//import com.example.demo.api.domain.LatLng;
//import com.example.demo.model.Country;
//import com.example.demo.service.ParsingService;
//import com.example.demo.service.JsonParsingService;
//import com.example.demo.service.CountryService;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/country")
//public class CountryController {
//
//    private static final String JSON_COUNTRY_URL = "https://restcountries.eu/rest/v2/";
//
//    private final CountryService countryService;
//
//
//    @Autowired
//    public CountryController(CountryService countryService) {
//        this.countryService = countryService;
//    }
//
//    @Autowired
//    private ParsingService parsingService;
//
//    @Autowired
//    private JsonParsingService jsonParsingService;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @GetMapping(path ="all")
//    public List<Country> main( final Model model){
//        List<Country> countries =  (List<Country>) parsingService.parse(JSON_COUNTRY_URL+"all");
//        model.addAttribute("country", countries.get(0));
//        return countries;
//    }
//
//
//    @GetMapping(path ="{name}")
//    public List<Country> countryByName(@PathVariable("name") String name, final Model model){
//        List<Country> countries =  (List<Country>) parsingService.parse(JSON_COUNTRY_URL+"name/"+ name );
//        model.addAttribute("country", countries.get(0));
//        return countries;
//    }
//
//    @PostMapping
//    public void addCountry(@Valid @NotNull @RequestBody Country country, LatLng latlng) {
//        countryService.addCountry(country, latlng);
//    }
//
//    @PostMapping(path ="{name}")
//    public List<Country> addCountryToDb(@PathVariable("name") String name, final Model model){
//        List<Country> countries =  (List<Country>) parsingService.parse(JSON_COUNTRY_URL+"name/"+ name );
//        List<LatLng> latLan =  (List<LatLng>) parsingService.parse(JSON_COUNTRY_URL+"name/"+ name );
//        model.addAttribute("country", countries.get(0));
//
//        List<Country> accountList = mapper.convertValue(
//                countries,
//                new TypeReference<List<Country>>(){}
//        );
//        List<LatLng> latLngList = mapper.convertValue(
//                latLan,
//                new TypeReference<List<LatLng>>(){}
//        );
//        countryService.addCountry(accountList.get(0),latLngList.get(0));
//        return countries;
//    }
//
//    @DeleteMapping (path ="{id}")
//    public void deleteCountryById(@PathVariable("id") Integer id) {
//        countryService.deleteCountry(id);
//    }
//}
