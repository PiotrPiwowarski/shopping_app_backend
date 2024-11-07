package com.example.shopping_app_backend.exceptions;

import lombok.Getter;

@Getter
public class NoItemsWithSuchIdException extends RuntimeException {

    private final String message;

    public NoItemsWithSuchIdException() {
        this.message = "Brak produktów o podanym id";
    }
}
