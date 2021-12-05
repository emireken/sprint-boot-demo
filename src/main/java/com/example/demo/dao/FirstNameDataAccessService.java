//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.FirstName;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FirstNameDataAccessService implements FirstNameDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FirstNameDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FirstName> selectAllFirstNames() {
        String sql = "SELECT  * FROM \"first_name\"";
        return this.jdbcTemplate.query(sql, this.mapNameFomDb());
    }

    public List<FirstName> getRandomFirstName() {
        String sql = "SELECT  * FROM \"first_name\"order by random() limit 1";
        return this.jdbcTemplate.query(sql, this.mapNameFomDb());
    }

    public List<FirstName> getNumberOfRandomFirstName(Integer numberOfRandom) {
        String sql = "SELECT  * FROM \"first_name\"order by random() limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{numberOfRandom}, this.mapNameFomDb());
    }

    public List<FirstName> getRandomFirstNameByLocale(String locale) {
        String sql = "SELECT  * FROM \"first_name\"WHERE locale=? order by random() limit 1";
        return this.jdbcTemplate.query(sql, new Object[]{locale}, this.mapNameFomDb());
    }

    public List<FirstName> getNumberOfRandomFirstNamByLocale(String locale, Integer numberOfRandom) {
        String sql = "SELECT  * FROM \"first_name\"WHERE locale=? order by random() limit ?";
        return this.jdbcTemplate.query(sql, new Object[]{locale, numberOfRandom}, this.mapNameFomDb());
    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    private RowMapper<FirstName> mapNameFomDb() {
        return (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String locale = resultSet.getString("locale");
            String gender = resultSet.getString("gender");
            return new FirstName(id, first_name, locale, gender);
        };
    }
}
