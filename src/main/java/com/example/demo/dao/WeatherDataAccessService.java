package com.example.demo.dao;

import com.example.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDataAccessService implements WeatherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WeatherDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Weather> selectAllWeathers() {
        String sql = "SELECT * FROM weather";
        return jdbcTemplate.query(sql, mapWeatherFomDb());
    }

    @Override
    public int insertWeather(Integer id, Weather weatherMain) {
        String sql = "INSERT INTO weather (id,  weatherMain ) VALUES ( (SELECT count(*) id FROM weather)+?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                weatherMain
        );
    }

    @Override
    public int deleteWeatherById(Integer id) {
        String sql = "DELETE FROM weather WHERE id =?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateWeatherById(Integer id, Weather weather) {
        return 0;
    }

    @Override
    public Optional<Weather> selectWeatherById(Integer id) {
        String sql = "SELECT * FROM weather WHERE id = ?";
        Weather weather = getJdbcTemplate().queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    Integer weatherId = resultSet.getInt("id");
                    Integer temperature = resultSet.getInt("temperature");

                    String weatherMain = resultSet.getString("weatherMain");
                    String weatherIcon = resultSet.getString("weatherIcon");
                    String weatherDescription = resultSet.getString("weatherDescription");
                    String countryCode = resultSet.getString("countryCode");
                    String name = resultSet.getString("name");

                    Timestamp timestamp = resultSet.getTimestamp("timestamp");
                    Timestamp sunrise = resultSet.getTimestamp("sunrise");
                    Timestamp sunset = resultSet.getTimestamp("sunset");
                    return new Weather();
                });
        return Optional.ofNullable(weather);

        //return jdbcTemplate.query(sql, mapWeatherFomDb());
    }


    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private RowMapper<Weather> mapWeatherFomDb() {
        return (resultSet, i) -> {
            Integer weatherId = resultSet.getInt("id");
            Integer temperature = resultSet.getInt("temperature");

            String weatherMain = resultSet.getString("weatherMain");
            String weatherIcon = resultSet.getString("weatherIcon");
            String weatherDescription = resultSet.getString("weatherDescription");
            String countryCode = resultSet.getString("countryCode");
            String name = resultSet.getString("name");

            Timestamp timestamp = resultSet.getTimestamp("timestamp");
            Timestamp sunrise = resultSet.getTimestamp("sunrise");
            Timestamp sunset = resultSet.getTimestamp("sunset");

            return new Weather();
        };
    }
}
