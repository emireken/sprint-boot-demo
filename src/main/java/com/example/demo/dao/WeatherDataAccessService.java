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
        String sql = "" +
                "SELECT " +
                " id, " +
                " visibility " +
                "FROM weather";
        return jdbcTemplate.query(sql, mapWeatherFomDb());
    }

    @Override
    public int insertWeather(Integer id, Weather weather) {
        String sql = "INSERT INTO weather (id,  visibility ) VALUES ( (SELECT count(*) id FROM weather)+?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                weather.getVisibility()
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
        final String sql = "SELECT id, visibility, weatherMains FROM weather WHERE id = ?";
        Weather weather = getJdbcTemplate().queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    Integer weatherId = resultSet.getInt("id");
                    Integer visibility = resultSet.getInt("visibility");
                    return new Weather(weatherId,visibility);
                });
        return Optional.ofNullable(weather);
    }

    private JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private RowMapper<Weather> mapWeatherFomDb() {
        return (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            Integer visibility = resultSet.getInt("visibility");
            return new Weather(id, visibility);
        };
    }
}
