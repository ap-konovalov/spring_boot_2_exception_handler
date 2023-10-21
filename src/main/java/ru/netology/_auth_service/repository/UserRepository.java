package ru.netology._auth_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology._auth_service.entities.Authorities;
import ru.netology._auth_service.entities.User;
import ru.netology._auth_service.provider.UsersProvider;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> usersCredentialsStorage = new ConcurrentHashMap<>();

    public UserRepository() {
        usersCredentialsStorage.put(UsersProvider.getUser("admin", "admin"),
                List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        usersCredentialsStorage.put(UsersProvider.getUser("user", "123"), List.of(Authorities.READ));
        usersCredentialsStorage.put(UsersProvider.getUser("noAuthorities", "123"), List.of());
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (usersCredentialsStorage.containsKey(user)) {
            return usersCredentialsStorage.get(user);
        }
        return Collections.emptyList();
    }
}
