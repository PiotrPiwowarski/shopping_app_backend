package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class NoUsersWithSuchCredentialsException extends RuntimeException {

    private final String message;

    public NoUsersWithSuchCredentialsException() {
        this.message = "Brak użytkowników o podanych danych do logowania";
    }
}
