//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.api.controller;

import com.example.demo.model.DataType;
import com.example.demo.service.DataTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1/dataTypes"})
public class DataTypeController {
    private final DataTypeService dataTypeService;

    @Autowired
    public DataTypeController(DataTypeService dataTypeService) {
        this.dataTypeService = dataTypeService;
    }

    @GetMapping(
            path = {"all"}
    )
    public List<DataType> getAllFirstNames() {
        return this.dataTypeService.getAllDataTypes();
    }
}
