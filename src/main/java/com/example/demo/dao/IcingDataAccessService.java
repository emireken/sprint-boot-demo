//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.Icing;
import com.example.demo.service.JsonParsingService;
import com.example.demo.service.ParsingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IcingDataAccessService implements IcingDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ParsingService parsingService;
    @Autowired
    private JsonParsingService jsonParsingService;

    @Autowired
    public IcingDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public Object getIcing(String weather) {
        ObjectMapper objectMapper = new ObjectMapper();
        Icing icing = null;

        try {
            icing = (Icing)objectMapper.readValue(weather, Icing.class);
        } catch (JsonProcessingException var5) {
            var5.printStackTrace();
        }

        Double dewPoint = icing.getTemp() - (100.0D - Double.valueOf((double)icing.getHumidity())) / 5.0D;
        return dewPoint;
    }
}
