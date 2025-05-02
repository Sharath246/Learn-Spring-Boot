package com.temp.temp.Workspace.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.temp.User.Entity.User;

@Repository
public class WorkspaceRepository {
    private final JdbcTemplate jdbc;

    public WorkspaceRepository(JdbcTemplate jdbc){
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

    // public RowMapper<String> RolesRowMapper = new RowMapper<String>() {
    //     @Override
    //     public String mapRow(ResultSet rs, int row) throws SQLException {
    //         return rs.getString("role");
    //     }
    // };

    public List<User> allUsersForTask(){
        String sql = "select * from ";
        return jdbc.query(sql, UserRowMapper);
    }

    // public User getUserbyEmail(String email){
    //     String sql = "select top 1  * from users where email = '" + email + "';";
    //     return jdbc.query(sql, UserRowMapper).get(0);
    // }

    // public List<String> getUserRoles(String email){
    //     User user = getUserbyEmail(email);
    //     if(user == null)
    //         return null;
    //     else{
    //         String sql = "select * from roles where id = '" + user.getId() + "';";
    //         return jdbc.query(sql,RolesRowMapper);
    //     }
    // }
}
