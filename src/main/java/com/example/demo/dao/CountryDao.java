package com.example.demo.dao;

import com.example.demo.model.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryDao {

    int insertCountry(UUID id, Country country);

    default int insertCountry(Country country){
        UUID id = UUID.randomUUID();
        return  insertCountry(id, country);
    }

    List<Country> selectAllCountries();

    Optional<Country> selectCountryById(UUID id);

    int deleteCountryById(UUID id);
    int updateCountryById(UUID id, Country country);

}
