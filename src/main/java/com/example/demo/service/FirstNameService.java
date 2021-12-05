//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dao.FirstNameDataAccessService;
import com.example.demo.model.FirstName;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstNameService {
    private final FirstNameDataAccessService firstNameDataAccessService;

    @Autowired
    public FirstNameService(FirstNameDataAccessService firstNameDataAccessService) {
        this.firstNameDataAccessService = firstNameDataAccessService;
    }

    public List<FirstName> getAllFirstNames() {
        return this.firstNameDataAccessService.selectAllFirstNames();
    }

    public List<FirstName> getRandomFirstName() {
        return this.firstNameDataAccessService.getRandomFirstName();
    }

    public List<FirstName> getNumberOfRandomFirstName(Integer numberOfRandom) {
        return this.firstNameDataAccessService.getNumberOfRandomFirstName(numberOfRandom);
    }

    public List<FirstName> getRandomFirstNameByLocale(String locale) {
        return this.firstNameDataAccessService.getRandomFirstNameByLocale(locale);
    }

    public List<FirstName> getNumberOfRandomFirstNameByLocale(String locale, Integer numberOfRandom) {
        return this.firstNameDataAccessService.getNumberOfRandomFirstNamByLocale(locale, numberOfRandom);
    }
}
