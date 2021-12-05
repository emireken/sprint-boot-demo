//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.Color;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ColorDataAccessService implements ColorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ColorDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Color> selectAllColors() {
        String sql = "SELECT  * FROM \"colorList\"";
        return this.jdbcTemplate.query(sql, this.mapColorFomDb());
    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public List<Color> selectColorsByModel(Integer modelId) {
        String sql = "SELECT  * FROM \"colorList\" WHERE \"modelId\" = ? ";
        return this.jdbcTemplate.query("SELECT  * FROM \"colorList\" WHERE \"modelId\" = ? ", new Object[]{modelId}, this.mapColorFomDb());
    }

    private RowMapper<Color> mapColorFomDb() {
        return (resultSet, i) -> {
            String id = resultSet.getString("id");
            String description = resultSet.getString("description");
            Integer modelId = resultSet.getInt("modelId");
            return new Color(id, description, modelId);
        };
    }
}
