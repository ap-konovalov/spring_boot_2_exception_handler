package ru.netology._auth_service.services;

import org.springframework.stereotype.Service;
import ru.netology._auth_service.entities.Authorities;
import ru.netology._auth_service.exceptions.InvalidCredentials;
import ru.netology._auth_service.exceptions.UnauthorizedUser;
import ru.netology._auth_service.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    private boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
