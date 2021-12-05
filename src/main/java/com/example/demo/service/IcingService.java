//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.IcingDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IcingService {
    private IcingDataAccessService icingDataAccessService;

    @Autowired
    public IcingService(IcingDataAccessService icingDataAccessService) {
        this.icingDataAccessService = icingDataAccessService;
    }

    public Object getIcing(String weather) {
        Object icing = this.icingDataAccessService.getIcing(weather);
        return icing;
    }
}
