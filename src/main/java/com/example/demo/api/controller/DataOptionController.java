package com.example.demo.api.controller;

import com.example.demo.model.DataOption;
import com.example.demo.model.FirstName;
import com.example.demo.service.DataOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/v1/dataOptions"})
public class DataOptionController {
    private final DataOptionService dataOptionService;

    @Autowired
    public DataOptionController(DataOptionService dataOptionService) {
        this.dataOptionService = dataOptionService;
    }

    @GetMapping(
            path = {"all"}
    )
    public List<DataOption> getAllOptions() {
        return this.dataOptionService.getAllDataOptions();
    }

    @RequestMapping(
            value = {"{optionID}"},
            method = {RequestMethod.GET}
    )
    public List<DataOption> getDataOptionByID(@RequestParam("optionID") Integer optionID) {
        return this.dataOptionService.getDataOptionByID(optionID);
    }

}
