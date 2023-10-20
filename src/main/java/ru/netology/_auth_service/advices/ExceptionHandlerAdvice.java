package ru.netology._auth_service.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology._auth_service.exceptions.InvalidCredentials;
import ru.netology._auth_service.exceptions.UnauthorizedUser;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials invalidCredentials) {
        return new ResponseEntity<>(invalidCredentials.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser unauthorizedUser) {
        return new ResponseEntity<>(unauthorizedUser.getMessage(), UNAUTHORIZED);
    }
}
