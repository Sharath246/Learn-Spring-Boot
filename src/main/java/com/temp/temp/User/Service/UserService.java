package com.temp.temp.User.Service;

import java.util.List;

import com.temp.temp.User.DTO.RegisterDTO;
import com.temp.temp.User.Entity.User;
import com.temp.temp.User.Enums.Roles;

public interface UserService {

    public User getUser(String email);
    public void addUser(RegisterDTO userDetails);
    public List<User> getAllUsers();
    public List<Roles> getUserRoles(String email);

}
