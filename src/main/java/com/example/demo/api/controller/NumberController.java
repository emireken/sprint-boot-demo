//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.service.NumberService;
import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/Number"})
public class NumberController {
    public NumberController() {
    }

    @RequestMapping(
            value = {"randomPercent"},
            method = {RequestMethod.GET}
    )
    public Integer getRandomPercent() {
        return NumberService.getRandomPercent();
    }

    @RequestMapping(
            value = {"num"},
            method = {RequestMethod.GET}
    )
    public ArrayList getNumberOfRandomNumber(@RequestParam("numberOfRandom") Integer numberOfRandom, final Model model) {
        return NumberService.getNumberOfRandomNumber(numberOfRandom);
    }

    @RequestMapping(
            value = {"randomNumberMinMax"},
            method = {RequestMethod.GET}
    )
    @NotBlank
    public Integer getRandomNumberMinMax(Integer min, Integer max) {
        return NumberService.getRandomNumberMinMax(min, max);
    }
}
