package com.example.shopping_app_backend.dto;

import com.example.shopping_app_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetUser {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
