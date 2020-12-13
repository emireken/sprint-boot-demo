package com.example.demo.dao;

import com.example.demo.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryDao {

    int insertCountry(Integer id, Country country);

    default int insertCountry(Country country){
        Integer id = 0;
        return  insertCountry(id, country);
    }

    List<Country> selectAllCountries();

    Optional<Country> selectCountryById(Integer id);

    int deleteCountryById(Integer id);
    int updateCountryById(Integer id, Country country);

}
