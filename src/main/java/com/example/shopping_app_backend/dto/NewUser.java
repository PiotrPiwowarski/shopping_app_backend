package com.example.shopping_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
