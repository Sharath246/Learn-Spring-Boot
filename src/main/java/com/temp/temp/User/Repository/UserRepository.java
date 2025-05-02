package com.temp.temp.User.Repository;

import com.temp.temp.User.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository{
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public RowMapper<User> UserRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int row) throws SQLException{
            new User();
            User user = User.builder()
                .email(rs.getString("email"))
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .build();
            return user;
        }
    };

    public RowMapper<String> RolesRowMapper = new RowMapper<String>() {
        @Override
        public String mapRow(ResultSet rs, int row) throws SQLException {
            return rs.getString("role");
        }
    };

    public List<User> findAllUSers(){
        String sql = "select * from users;";
        return jdbc.query(sql, UserRowMapper);
    }

    public User getUserbyEmail(String email){
        String sql = "select top 1  * from users where email = '" + email + "';";
        return jdbc.query(sql, UserRowMapper).get(0);
    }

    public List<String> getUserRoles(String email){
        User user = getUserbyEmail(email);
        if(user == null)
            return null;
        else{
            String sql = "select * from roles where id = '" + user.getId() + "';";
            return jdbc.query(sql,RolesRowMapper);
        }
    }

    
}
