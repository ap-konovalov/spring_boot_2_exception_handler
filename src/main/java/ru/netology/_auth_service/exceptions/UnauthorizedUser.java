package ru.netology._auth_service.exceptions;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String message) {
        super(message);
    }
}
