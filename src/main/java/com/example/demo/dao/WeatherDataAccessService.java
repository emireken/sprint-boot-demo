package com.example.demo.dao;

import com.example.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
    public int insertWeather(Weather Weather) {
        String sql = "INSERT INTO " +
                "weather (\"weatherId\", temperature, \"weatherMain\", \"weatherIcon\", \"weatherDescription\", \"countryCode\", name, \"timestamp\", \"sunrise\", \"sunset\") " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] {
                        Weather.getWeatherId(),
                        Weather.getTemperature(),
                        Weather.getWeatherMain(),
                        Weather.getWeatherIcon(),
                        Weather.getWeatherDescription(),
                        Weather.getCountryCode(),
                        Weather.getName(),
                        Weather.getTimestamp(),
                        Weather.getSunrise(),
                        Weather.getSunset(),
        });
    }
    @Override
    public int deleteWeatherById(Integer id) {
        String sql = "DELETE FROM weather WHERE \"weatherId\" =?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateWeatherById(Integer id, Weather weather) {
        return 0;
    }

    @Override
    public Optional<Weather> selectWeatherById(Integer id) {
        String sql = "SELECT * FROM weather WHERE \"weatherId\" = ?";
        Weather weather = getJdbcTemplate().queryForObject(sql, new Object[]{id}, mapWeatherFomDb());
        return Optional.ofNullable(weather);
    }

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private RowMapper<Weather> mapWeatherFomDb() {
        return (resultSet, i) -> {
            Integer weatherId = resultSet.getInt("weatherId");
            Integer temperature = resultSet.getInt("temperature");
            String weatherMain = resultSet.getString("weatherMain");
            String weatherIcon = resultSet.getString("weatherIcon");
            String weatherDescription = resultSet.getString("weatherDescription");
            String countryCode = resultSet.getString("countryCode");
            String name = resultSet.getString("name");
            Long timestamp = resultSet.getLong("timestamp");
            Long sunrise = resultSet.getLong("sunrise");
            Long sunset = resultSet.getLong("sunset");

            return new Weather(weatherId, temperature, weatherMain, weatherIcon, weatherDescription, countryCode, name, timestamp, sunrise, sunset );
        };
    }
}
