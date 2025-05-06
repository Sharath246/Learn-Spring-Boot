package com.temp.temp.Security.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderServiceImpl implements PasswordEncoder{

    private final BCryptPasswordEncoder encoder;

    public PasswordEncoderServiceImpl(BCryptPasswordEncoder encoder){
        this.encoder = encoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.encode(rawPassword).equals(encodedPassword);
    }
    
}
