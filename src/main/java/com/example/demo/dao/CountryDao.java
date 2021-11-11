//package com.example.demo.dao;
//
//import com.example.demo.api.domain.LatLng;
//import com.example.demo.model.Country;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CountryDao {
//
//    int insertCountry(Integer id, Country country, LatLng latlng);
//
//    default int insertCountry(Country country, LatLng latlng){
//        Integer id = 0;
//        return  insertCountry(id, country, latlng);
//    }
//
//    List<Country> selectAllCountries();
//
//    Optional<Country> selectCountryById(Integer id);
//
//    int deleteCountryById(Integer id);
//    int updateCountryById(Integer id, Country country);
//
//}
