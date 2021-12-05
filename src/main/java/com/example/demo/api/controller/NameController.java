//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.Name;
import com.example.demo.service.NameService;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/Name"})
public class NameController {
    public NameController() {
    }

    @GetMapping(
            path = {"random"}
    )
    public Name getRandomName() {
        return NameService.getRandomName();
    }

    @RequestMapping(
            value = {"num"},
            method = {RequestMethod.GET}
    )
    public ArrayList<Name> getNumberOfRandomName(@RequestParam("numberOfRandom") Integer numberOfRandom, final Model model) {
        return (ArrayList)NameService.getNumberOfRandomName(numberOfRandom);
    }

    @RequestMapping(
            value = {"locale"},
            method = {RequestMethod.GET}
    )
    public Name getRandomNameByLocale(@RequestParam("locale") String locale) {
        return NameService.getRandomNameByLocale(locale);
    }

    @RequestMapping(
            value = {"locNum"},
            method = {RequestMethod.GET}
    )
    public ArrayList<Name> getNumberOfRandomNameByLocale(@RequestParam("localenumberOfRandom") String locale, Integer numberOfRandom) {
        return (ArrayList)NameService.getNumberOfRandomNameByLocale(locale, numberOfRandom);
    }
}
