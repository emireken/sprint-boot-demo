package com.example.demo.service;

import com.example.demo.dao.CountryDataAccessService;
import com.example.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {

    private final CountryDataAccessService countryDataAccessService;


    @Autowired
    public CountryService(CountryDataAccessService countryDataAccessService, CountryDataAccessService countryDataAccessService1) {
        this.countryDataAccessService = countryDataAccessService1;
    }

    public List<Country> getAllCountries(){
        return countryDataAccessService.selectAllCountries();
    }

    public int addCountry(Country country) {
        return countryDataAccessService.insertCountry(country);
    }

    public Optional<Country> getCountryById (UUID id) {
        return countryDataAccessService.selectCountryById(id);
    }

    public int deleteCountry(UUID id) {
        return countryDataAccessService.deleteCountryById(id);
    }

    public int updateCountry(UUID id, Country newCountry) {
        return countryDataAccessService.updateCountryById(id, newCountry);
    }

}
