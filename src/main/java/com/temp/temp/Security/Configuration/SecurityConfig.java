package com.temp.temp.Security.Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.temp.temp.Security.Service.PasswordEncoderServiceImpl;
import com.temp.temp.Security.Service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

    private final JdbcTemplate jdbc;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //change this afterwards

    public SecurityConfig(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource datasource){
        return new UserDetailsServiceImpl(jdbc,encoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderServiceImpl(encoder);
    }

}
