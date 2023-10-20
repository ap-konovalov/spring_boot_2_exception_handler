package ru.netology._auth_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology._auth_service.entities.Authorities;
import ru.netology._auth_service.services.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user,
                                            @RequestParam("password") String password) {
        return authorizationService.getAuthorities(user, password);
    }
}
