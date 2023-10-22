package ru.netology._auth_service.services;

import org.springframework.stereotype.Service;
import ru.netology._auth_service.entities.Authorities;
import ru.netology._auth_service.entities.User;
import ru.netology._auth_service.exceptions.UnauthorizedUser;
import ru.netology._auth_service.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
