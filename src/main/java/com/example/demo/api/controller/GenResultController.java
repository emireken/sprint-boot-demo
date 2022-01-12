package com.example.demo.api.controller;

import com.example.demo.model.DataGen;
import com.example.demo.model.GenResult;
import com.example.demo.model.Name;
import com.example.demo.service.NameService;
import com.example.demo.service.NumberService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

@RestController
@RequestMapping("api/v1/GenResult")
public class GenResultController {

    @RequestMapping(method = RequestMethod.POST)
    public GenResult getResData(@RequestBody GenResult ResData) {
        return ResData ;

    }
}
