package ru.netology._auth_service.exceptions;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String message) {
        super(message);
    }
}
