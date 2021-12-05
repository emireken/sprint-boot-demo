//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.FirstName;
import com.example.demo.service.FirstNameService;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/firstName"})
public class FirstNameController {
    private final FirstNameService firstNameService;
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public FirstNameController(FirstNameService firstNameService) {
        this.firstNameService = firstNameService;
    }

    @GetMapping(
            path = {"all"}
    )
    public List<FirstName> getAllFirstNames() {
        return this.firstNameService.getAllFirstNames();
    }

    @GetMapping(
            path = {"random"}
    )
    public List<FirstName> getRandomFirstName() {
        return this.firstNameService.getRandomFirstName();
    }

    @RequestMapping(
            value = {"{numberOfRandom}"},
            method = {RequestMethod.GET}
    )
    public List<FirstName> getNumberOfRandomFirstName(@RequestParam("numberOfRandom") Integer numberOfRandom) {
        return this.firstNameService.getNumberOfRandomFirstName(numberOfRandom);
    }

    @RequestMapping(
            value = {"{locale}"},
            method = {RequestMethod.GET}
    )
    public List<FirstName> getRandomFirstNameByLocale(@RequestParam("locale") String locale) {
        return this.firstNameService.getRandomFirstNameByLocale(locale);
    }

    @RequestMapping(
            value = {"{locale}/{numberOfRandom}"},
            method = {RequestMethod.GET}
    )
    public List<FirstName> getNumberOfRandomFirstNameByLocale(@RequestParam("localenumberOfRandom") String locale, Integer numberOfRandom) {
        return this.firstNameService.getNumberOfRandomFirstNameByLocale(locale, numberOfRandom);
    }
}
