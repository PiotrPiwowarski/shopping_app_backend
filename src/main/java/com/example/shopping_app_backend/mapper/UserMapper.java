package com.example.shopping_app_backend.mapper;

import com.example.shopping_app_backend.dto.GetUser;
import com.example.shopping_app_backend.dto.NewUser;
import com.example.shopping_app_backend.entity.User;
import com.example.shopping_app_backend.enums.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    public static User map(NewUser newUser, PasswordEncoder passwordEncoder) {
        return User.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .email(newUser.getEmail())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .role(Role.USER)
                .build();
    }

    public static GetUser map(User user) {
        return GetUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
