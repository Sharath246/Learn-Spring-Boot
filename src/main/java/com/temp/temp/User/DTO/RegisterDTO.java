package com.temp.temp.User.DTO;

import java.util.List;
import com.temp.temp.User.Enums.Roles;

public record RegisterDTO(String email, String username, String pasword, List<Roles> roles) {
}
