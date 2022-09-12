//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.DataOptionDataAccessService;
import com.example.demo.dao.DataTypeDataAccessService;
import com.example.demo.model.DataOption;
import com.example.demo.model.DataType;
import com.example.demo.model.FirstName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataOptionService {
    private final DataOptionDataAccessService dataOptionDataAccessService;

    @Autowired
    public DataOptionService(DataOptionDataAccessService dataOptionDataAccessService) {
        this.dataOptionDataAccessService = dataOptionDataAccessService;
    }

    public List<DataOption> getAllDataOptions() {
        return this.dataOptionDataAccessService.selectAllDataOptions();
    }

    public List<DataOption> getDataOptionByID(Integer optionID) {
        return this.dataOptionDataAccessService.getDataOptionByID(optionID);
    }

}
