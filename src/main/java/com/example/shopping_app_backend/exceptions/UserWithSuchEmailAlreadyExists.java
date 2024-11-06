package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class UserWithSuchEmailAlreadyExists extends RuntimeException {

    private final String message;

    public UserWithSuchEmailAlreadyExists() {
        this.message = "Użytkownik o podanym emailu już istnieje";
    }
}
