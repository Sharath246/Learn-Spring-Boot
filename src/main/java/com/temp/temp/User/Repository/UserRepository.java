package com.temp.temp.User.Repository;

import org.springframework.stereotype.Repository;
import com.temp.temp.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
                .id(rs.getLong("ID"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                // .roles(rs.getArray("roles"))
                .build();
            return user;
        }
    };

    // public List<User> findAllUSers(){
    //     String sql = "";
    //     return 
    // }
}
