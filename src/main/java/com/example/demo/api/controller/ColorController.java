//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.Color;
import com.example.demo.service.ColorService;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/color"})
public class ColorController {
    private final ColorService colorService;
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping(
            path = {"all"}
    )
    public List<Color> getAllColors() {
        return this.colorService.getAllColors();
    }

    @GetMapping(
            path = {"{modelId}"}
    )
    public List<Color> getColorsByModel(@PathVariable("modelId") Integer modelId, final Model model) {
        return this.colorService.getColorsByModel(modelId);
    }
}
