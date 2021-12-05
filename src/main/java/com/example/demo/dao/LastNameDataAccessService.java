//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.LastName;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LastNameDataAccessService implements LastNameDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LastNameDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<LastName> selectAllLastNames() {
        String sql = "SELECT  * FROM \"last_name\"";
        return this.jdbcTemplate.query(sql, this.mapNameFomDb());
    }

    public List<LastName> getRandomLastName() {
        String sql = "SELECT  * FROM \"last_name\"order by random() limit 1";
        return this.jdbcTemplate.query(sql, this.mapNameFomDb());
    }

    public List<LastName> getNumberOfRandomLastName(Integer numberOfRandom) {
        String sql = "SELECT  * FROM \"last_name\"order by random() limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{numberOfRandom}, this.mapNameFomDb());
    }

    public List<LastName> getRandomLastNameByLocale(String locale) {
        String sql = "SELECT  * FROM \"last_name\"WHERE locale=? order by random() limit 1";
        return this.jdbcTemplate.query(sql, new Object[]{locale}, this.mapNameFomDb());
    }

    public List<LastName> getNumberOfRandomLastNameByLocale(String locale, Integer numberOfRandom) {
        String sql = "SELECT  * FROM \"last_name\"WHERE locale=? order by random() limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{locale, numberOfRandom}, this.mapNameFomDb());
    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    private RowMapper<LastName> mapNameFomDb() {
        return (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String last_name = resultSet.getString("last_name");
            String locale = resultSet.getString("locale");
            return new LastName(id, last_name, locale);
        };
    }
}
