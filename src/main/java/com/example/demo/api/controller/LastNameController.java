//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.LastName;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.LastNameService;
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
@RequestMapping({"api/v1/lastName"})
public class LastNameController {
    private final LastNameService lastNameService;
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public LastNameController(LastNameService lastNameService) {
        this.lastNameService = lastNameService;
    }

    @GetMapping(
            path = {"all"}
    )
    public List<LastName> getAllLastNames() {
        return this.lastNameService.getAllLastNames();
    }

    @GetMapping(
            path = {"random"}
    )
    public List<LastName> getRandomLastName() {
        return this.lastNameService.getRandomLastName();
    }

    @RequestMapping(
            value = {"{numberOfRandom}"},
            method = {RequestMethod.GET}
    )
    public List<LastName> getNumberOfRandomLastName(@RequestParam("numberOfRandom") Integer numberOfRandom) {
        return this.lastNameService.getNumberOfRandomLastName(numberOfRandom);
    }

    @RequestMapping(
            value = {"{locale}"},
            method = {RequestMethod.GET}
    )
    public List<LastName> getRandomLastNameByLocale(@RequestParam("locale") String locale) {
        return this.lastNameService.getRandomLastNameByLocale(locale);
    }

    @RequestMapping(
            value = {"{locale}/{numberOfRandom}"},
            method = {RequestMethod.GET}
    )
    public List<LastName> getNumberOfRandomLastNameByLocale(@RequestParam("localenumberOfRandom") String locale, Integer numberOfRandom) {
        return this.lastNameService.getNumberOfRandomLastNameByLocale(locale, numberOfRandom);
    }
}
