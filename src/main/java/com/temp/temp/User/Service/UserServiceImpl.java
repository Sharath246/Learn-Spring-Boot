package com.temp.temp.User.Service;

import java.util.HashSet;
import java.util.List;

import com.temp.temp.User.DTO.RegisterDTO;
import com.temp.temp.User.Entity.User;
import com.temp.temp.User.Enums.Roles;
import com.temp.temp.User.Repository.UserRepository;

public class UserServiceImpl {
    // private final UserRepository userRepo;

    // public UserServiceImpl(UserRepository userRepo){
    //     this.userRepo = userRepo;
    // }


    // public User getUser(String email){
    //     List<User> allUSers = userRepo.findByEmail(email);
    //     return allUSers.size() > 0 ? allUSers.get(0) : null;
    // }

    // public List<User> getAllUsers(){
    //     return userRepo.findAll();
    // }

    // public void addUser(RegisterDTO userDetails){
    //     User new_user = User.builder()
    //         .email(userDetails.email())
    //         .username(userDetails.username())
    //         .password(userDetails.pasword())
    //         .roles(new HashSet<>(userDetails.roles()))
    //         .build();
    //     userRepo.save(new_user);
    // }

    // public List<Roles> getUserRoles(String email){
    //     User user = getUser(email);
    //     return user.getRoles().stream().toList();
    // }
}
