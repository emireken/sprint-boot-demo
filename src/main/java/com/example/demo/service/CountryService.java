//package com.example.demo.service;
//
//import com.example.demo.api.domain.LatLng;
//import com.example.demo.dao.CountryDataAccessService;
//import com.example.demo.model.Country;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CountryService {
//
//    private final CountryDataAccessService countryDataAccessService;
//
//
//   @Autowired
//    public CountryService(CountryDataAccessService countryDataAccessService, CountryDataAccessService countryDataAccessService1) {
//        this.countryDataAccessService = countryDataAccessService1;
//    }
//
//    public List<Country> getAllCountries(){
//        return countryDataAccessService.selectAllCountries();
//    }
//
//    public int addCountry(Country country, LatLng latlng) {
//        return countryDataAccessService.insertCountry(country, latlng);
//    }
//
//    public Optional<Country> getCountryById (Integer id) {
//        return countryDataAccessService.selectCountryById(id);
//    }
//
//    public int deleteCountry(Integer id) {
//        return countryDataAccessService.deleteCountryById(id);
//    }
//
//    public int updateCountry(Integer id, Country newCountry) {
//        return countryDataAccessService.updateCountryById(id, newCountry);
//    }
//
//}
