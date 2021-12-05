//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.DataGen;
import com.example.demo.model.Name;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.NameService;
import com.example.demo.service.NumberService;
import com.example.demo.service.ParsingService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/dataGen"})
public class DataGenController {
    private static final String JSON_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=en&appid=e5def15cc837a57ebd4e07827b3e8912&lat=41.04473&lon=29.0353";
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;

    public DataGenController() {
    }

    @RequestMapping(
            method = {RequestMethod.POST}
    )
    public Object getGenData(@RequestBody String genData) {
        Gson g = new Gson();
        DataGen s = (DataGen)g.fromJson(genData, DataGen.class);
        ArrayList DataList = (ArrayList)s.getDataList();
        List<Name> newNameList = new ArrayList();
        List newNumberList = new ArrayList();
        ArrayList ResultName = new ArrayList();
        ArrayList ResultNumber = new ArrayList();
        ArrayList Result = new ArrayList();

        int i;
        for(i = 0; i < DataList.size(); ++i) {
            if (DataList.get(i).equals("Name")) {
                newNameList.addAll(NameService.getNumberOfRandomName(s.getDataSize()));
            } else if (DataList.get(i).equals("Number")) {
                newNumberList.addAll(NumberService.getNumberOfRandomNumber(s.getDataSize()));
            }
        }

        i = Math.max(newNameList.size(), newNumberList.size());

        for( i = 0; i < i; ++i) {
            if (newNameList.size() > 0) {
                ResultName.add(i, newNameList.get(i));
            }

            if (newNumberList.size() > 0) {
                ResultNumber.add(i, newNumberList.get(i));
            }
        }

        Result.add(ResultName);
        Result.add(ResultNumber);
        return Result;
    }
}
