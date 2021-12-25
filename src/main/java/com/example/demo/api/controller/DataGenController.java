//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import ch.qos.logback.core.util.COWArrayList;
import com.example.demo.model.DataGen;
import com.example.demo.model.Name;
import com.example.demo.model.ResultGen;
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

    public DataGenController() {
    }

    @RequestMapping(
            method = {RequestMethod.POST}
    )
    public Object getGenData(@RequestBody String genData) {
        Gson g = new Gson();
        DataGen s = g.fromJson(genData, DataGen.class);
        ArrayList DataList = (ArrayList) s.getDataList();
        ArrayList ResultJSON = new ArrayList();
        ArrayList ResultTempJSON = new ArrayList();

        for (int i = 0; i < s.getDataSize(); ++i) {
            ResultTempJSON = new ArrayList();
            for (int j = 0; j < DataList.size(); ++j) {
                if (DataList.get(j).equals("Name")) {
                    ResultTempJSON.add(j, (NameService.getRandomName()));
                } else if (DataList.get(j).equals("Number")) {
                    ResultTempJSON.add(j, (NumberService.getRandomNumber()));
                }
            }
            ResultJSON.add(i, ResultTempJSON);
        }
        return ResultJSON;
    }
}

//        for(i = 0; i < DataList.size(); ++i) {
//        if (DataList.get(i).equals("Name")) {
//                newNameList.addAll(NameService.getNumberOfRandomName(s.getDataSize()));
//        } else if (DataList.get(i).equals("Number")) {
//                newNumberList.add(NumberService.getNumberOfRandomNumber(s.getDataSize()));
//        }
//        }
