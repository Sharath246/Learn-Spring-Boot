package com.temp.temp.Security.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.temp.temp.Security.DTO.UserSecurityDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsManager{

    private final JdbcTemplate jdbc;
    private final BCryptPasswordEncoder encoder;

    public UserDetailsServiceImpl(JdbcTemplate jdbc, BCryptPasswordEncoder encoder){
        this.jdbc = jdbc;
        this.encoder = encoder;
    }

    public RowMapper<UserSecurityDTO> userRowMapper = new RowMapper<UserSecurityDTO>() {
        @Override
        public UserSecurityDTO mapRow(ResultSet rs, int row) throws SQLException{
            return UserSecurityDTO.builder()
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .build();
        }
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            String sql = "select top 1 * from users where username = '" + username + "';";
            return jdbc.query(sql, userRowMapper).get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void createUser(UserDetails user) {
        // String sql = "insert into users('username','password') values (" + user.getUsername() + "," + user.getPassword() + ");";
        // User should not be created here
    }

    @Override
    public void updateUser(UserDetails user) {
        // User details are not updated here
    }

    @Override
    public void deleteUser(String username) {
        // User should not be deleted from here
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // UserDetails user = loadUserByUsername()
        // String sql = "update table users set password = '" + encoder.encode(newPassword) + "' where username = "
    }

    @Override
    public boolean userExists(String username) {
        UserDetails user = loadUserByUsername(username);
        return user == null;
    }
    

}