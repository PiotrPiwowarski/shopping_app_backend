package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class NoUsersWithSuchIdException extends RuntimeException {

    private final String message;

    public NoUsersWithSuchIdException() {
        this.message = "Brak użytkowników o podanym id";
    }
}
