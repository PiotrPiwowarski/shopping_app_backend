package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class UnauthorizedActionException extends RuntimeException {

    private final String message;

    public UnauthorizedActionException() {
        this.message = "Brak uprawnień do wykonania tej operacji";
    }
}
