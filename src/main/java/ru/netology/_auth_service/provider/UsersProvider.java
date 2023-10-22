package ru.netology._auth_service.provider;

import lombok.experimental.UtilityClass;
import ru.netology._auth_service.entities.User;

@UtilityClass
public class UsersProvider {

    public User getUser(String userName, String password) {
        return User.builder()
                .user(userName)
                .password(password)
                .build();
    }
}
