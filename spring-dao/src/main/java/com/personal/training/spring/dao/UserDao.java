package com.personal.training.spring.dao;

import com.personal.training.spring.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Repository
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public User getUserById(Integer id) {
        Map<String, Integer> pkMap = new HashMap<String, Integer>();
        pkMap.put("userId", id);
        final List<User> users = jdbcTemplate.query("SELECT * FROM USER WHERE USER_ID = :userId", pkMap, (rs, rowNum) -> fillUserDetails(rs));
        return users.get(0);
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", (rs, rowNum) -> fillUserDetails(rs));
    }

    public int[] deleteUsers(List<Integer> users) {
        final List<SqlParameterSource> sqlParameterSources = users.parallelStream().map(id -> new MapSqlParameterSource().addValue("id", id)).collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("DELETE FROM USER WHERE USER_ID = :id ", sqlParameterSources.toArray(new SqlParameterSource[sqlParameterSources.size()]));
    }

    public int[] updateUsers(List<User> users) {
        final List<SqlParameterSource> sqlParameterSources = users.parallelStream().map(user -> setParameters(user)).collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("UPDATE USER SET NAME= :name, ADDRESS = :address, CITY = :city, DEPARTMENT = :department WHERE USER_ID = :id ", sqlParameterSources.toArray(new SqlParameterSource[sqlParameterSources.size()]));
    }

    private MapSqlParameterSource setParameters(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", user.getName());
        parameterSource.addValue("city", user.getCity());
        parameterSource.addValue("address", user.getAddress());
        parameterSource.addValue("department", user.getDepartment());
        parameterSource.addValue("id", user.getId());
        return parameterSource;
    }

    private User fillUserDetails(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("USER_ID"));
        user.setName(rs.getString("NAME"));
        user.setCity(rs.getString("CITY"));
        user.setAddress(rs.getString("ADDRESS"));
        user.setDepartment(rs.getString("DEPARTMENT"));
        return user;
    }

    public int[] addUsers(List<User> users) {
        final List<SqlParameterSource> sqlParameterSources = users.parallelStream().map(user -> setParameters(user)).collect(Collectors.toList());
        return jdbcTemplate.batchUpdate("INSERT INTO USER VALUES (:id, :name, :address, :city, :department)", sqlParameterSources.toArray(new SqlParameterSource[sqlParameterSources.size()]));
    }
}
