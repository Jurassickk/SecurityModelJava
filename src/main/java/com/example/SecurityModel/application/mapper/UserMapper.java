package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.UserDTO;
import com.example.SecurityModel.domain.entity.User;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        if (user == null) return null;
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .active(user.isActive())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setActive(userDTO.getActive());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
