package com.temp.temp.User.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.temp.temp.User.DTO.LoginDTO;
import com.temp.temp.User.DTO.RegisterDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam LoginDTO userDetails) {
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO userDetails) {
        return ResponseEntity.ok("Success");
    }
    
    
}
