package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class ThisTokenIsNotActiveException extends RuntimeException {

    private final String message;

    public ThisTokenIsNotActiveException() {
        this.message = "Ten token nie jest aktywny";
    }
}
