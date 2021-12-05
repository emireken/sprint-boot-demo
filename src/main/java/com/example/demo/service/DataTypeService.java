//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.DataTypeDataAccessService;
import com.example.demo.model.DataType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTypeService {
    private final DataTypeDataAccessService dataTypeDataAccessService;

    @Autowired
    public DataTypeService(DataTypeDataAccessService dataTypeDataAccessService) {
        this.dataTypeDataAccessService = dataTypeDataAccessService;
    }

    public List<DataType> getAllDataTypes() {
        return this.dataTypeDataAccessService.selectAllDataTypes();
    }
}
