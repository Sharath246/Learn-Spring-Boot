package com.temp.temp.User.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temp.temp.User.Entity.User;
import com.temp.temp.User.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public User getUser(String email){
        return userRepo.getUserbyEmail(email);
    }

    public List<String> getUserRoles(String email){
        return userRepo.getUserRoles(email);
    }

    public List<User> getAllUsers(){
        return userRepo.findAllUSers();
    }

    public boolean CheckRole(String email, String role){
        switch(role){
            case "Admin":
                return userRepo.getUserRoles(email).contains("Admin");
            case "Contributor":
                return userRepo.getUserRoles(email).contains("Contributor");
            case "Viewer":
                return userRepo.getUserRoles(email).contains("Viewer");
            default:
                return false;
        }
    }
}
