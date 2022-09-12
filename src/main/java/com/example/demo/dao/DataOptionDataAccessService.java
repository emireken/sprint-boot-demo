//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.dao;

import com.example.demo.model.DataOption;
import com.example.demo.model.DataType;
import com.example.demo.model.FirstName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataOptionDataAccessService implements DataOptionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataOptionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DataOption> selectAllDataOptions() {
        String sql = "SELECT  * FROM \"data_options\"";
        return this.jdbcTemplate.query(sql, this.mapDataOptionFomDb());
    }

    public List<DataOption> getDataOptionByID(Integer optionID) {
        String sql = "SELECT  * FROM \"data_options\" WHERE id=?";
        return this.jdbcTemplate.query(sql, new Object[]{optionID}, this.mapDataOptionFomDb());

    }

    private JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    private RowMapper<DataOption> mapDataOptionFomDb() {
        return (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String data_option = resultSet.getString("data_option");
            String data_option_name = resultSet.getString("data_option_name");
            return new DataOption(id,  data_option_name, data_option);
        };
    }


}
