package com.example.demo.dao;

import com.example.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CountryDataAccessService implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> selectAllCountries() {
        String sql = "" +
                "SELECT " +
                " id, " +
                " name " +
                "FROM country";

        return jdbcTemplate.query(sql, mapCountryFomDb());
    }

    @Override
    public int insertCountry(UUID id, Country country) {
        String sql = "" +
                "INSERT INTO country (" +
                " id, " +
                " name, " +
                " capital )" +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                country.getName(),
                country.getCapital()
        );
    }

    @Override
    public Optional<Country> selectCountryById(UUID id) {
        final String sql = "SELECT id, name, capital FROM country WHERE id = ?";
        Country country = getJdbcTemplate().queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID countryId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String capital = resultSet.getString("capital");
                    return new Country(id,name,capital);
                });
        return Optional.ofNullable(country);
    }

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public int deleteCountryById(UUID id) {
        final String sql = "DELETE FROM country WHERE id = ?";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateCountryById(UUID id, Country country) {
        return 0;
    }


    private RowMapper<Country> mapCountryFomDb() {
        return (resultSet, i) -> {
            String idStr = resultSet.getString("id");
            UUID id = UUID.fromString(idStr);
            String name = resultSet.getString("name");
            String capital = resultSet.getString("capital");
            return new Country(id,name,capital);
        };
    }
}