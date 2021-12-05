//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.LastNameDataAccessService;
import com.example.demo.model.LastName;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastNameService {
    private final LastNameDataAccessService lastNameDataAccessService;

    @Autowired
    public LastNameService(LastNameDataAccessService lastNameDataAccessService) {
        this.lastNameDataAccessService = lastNameDataAccessService;
    }

    public List<LastName> getAllLastNames() {
        return this.lastNameDataAccessService.selectAllLastNames();
    }

    public List<LastName> getRandomLastName() {
        return this.lastNameDataAccessService.getRandomLastName();
    }

    public List<LastName> getNumberOfRandomLastName(Integer numberOfRandom) {
        return this.lastNameDataAccessService.getNumberOfRandomLastName(numberOfRandom);
    }

    public List<LastName> getRandomLastNameByLocale(String locale) {
        return this.lastNameDataAccessService.getRandomLastNameByLocale(locale);
    }

    public List<LastName> getNumberOfRandomLastNameByLocale(String locale, Integer numberOfRandom) {
        return this.lastNameDataAccessService.getNumberOfRandomLastNameByLocale(locale, numberOfRandom);
    }
}
