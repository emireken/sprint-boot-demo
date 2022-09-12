//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.DataType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DataTypeDataAccessService implements DataTypeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataTypeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DataType> selectAllDataTypes() {
        String sql = "SELECT  * FROM \"data_types\"";
        return this.jdbcTemplate.query(sql, this.mapDataTypeFomDb());
    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    private RowMapper<DataType> mapDataTypeFomDb() {
        return (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String data_type_name = resultSet.getString("data_type_name");
            String data_type = resultSet.getString("data_type");
            String data_unit = resultSet.getString("data_unit");
            String data_options = resultSet.getString("data_options");
            return new DataType(id, data_type_name, data_type, data_unit, data_options);
        };
    }
}
