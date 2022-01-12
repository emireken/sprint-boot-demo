//package com.example.demo.dao;
//
//import com.example.demo.model.FirstName;
//import com.example.demo.model.LastName;
//import com.example.demo.model.Name;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import javax.validation.constraints.NotBlank;
//import java.util.List;
//
//@Repository
//public class NameDataAccessService implements NameDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public NameDataAccessService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public @NotBlank String getRandomName() {
//        String sql = "" +
//                "SELECT " +
//                " * " +
//                "FROM \"first_name\"" +
//                "order by random() limit 1";
//
//
//        List<FirstName> firstName = jdbcTemplate.query(sql, mapFirstNameFomDb());
//
//        String sql2 = "" +
//                "SELECT " +
//                " * " +
//                "FROM \"last_name\"" +
//                "order by random() limit 1";
//
//        List<LastName> lastName = jdbcTemplate.query(sql2, mapLastNameFomDb());
//
////        @NotBlank String Name = firstName.get(0) + lastName.get(0).last_name;
//        @NotBlank String Name = firstName.get(0).first_name + " " +lastName.get(0).last_name;
//
//        return(Name);
//    }
//
//    public List<Name> getNumberOfRandomName(Integer numberOfRandom) {
//        String sql = "" +
//                "SELECT " +
//                " * " +
//                "FROM \"first_name\"" +
//                "order by random() limit"+
//                " ?";
//
//        return jdbcTemplate.query(sql, new Object[]{numberOfRandom}, mapNameFomDb());
//    }
//    private JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//
////    public List<Name> selectColorsByModel(Integer modelId) {
////        final String sql = "SELECT  * FROM \"colorList\" WHERE \"modelId\" = ? ";
////
////        return jdbcTemplate.query(sql, new Object[]{modelId}, mapNameFomDb());
////    }
//
//    private RowMapper<Name> mapNameFomDb() {
//        return (resultSet, i) -> {
//            Integer id = resultSet.getInt("id");
//            String first_name = resultSet.getString("first_name");
//            String last_name = resultSet.getString("last_name");
//            String locale = resultSet.getString("locale");
//            String gender = resultSet.getString("gender");
//            return new Name(id,first_name,last_name,locale,gender);
//        };
//
//    }
//
//    private RowMapper<FirstName> mapFirstNameFomDb() {
//        return (resultSet, i) -> {
//            Integer id = resultSet.getInt("id");
//            String first_name = resultSet.getString("first_name");
//            String locale = resultSet.getString("locale");
//            String gender = resultSet.getString("gender");
//            return new FirstName(id,first_name,locale,gender);
//        };
//
//    }
//
//    private RowMapper<LastName> mapLastNameFomDb() {
//        return (resultSet, i) -> {
//            Integer id = resultSet.getInt("id");
//            String last_name = resultSet.getString("last_name");
//            String locale = resultSet.getString("locale");
//            return new LastName(id,last_name,locale);
//        };
//
//    }
//}