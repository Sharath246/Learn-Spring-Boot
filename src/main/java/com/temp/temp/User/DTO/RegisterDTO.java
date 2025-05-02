package com.temp.temp.User.DTO;

import java.util.List;

public record RegisterDTO(String email, String username, String pasword, List<String> roles) {
}
