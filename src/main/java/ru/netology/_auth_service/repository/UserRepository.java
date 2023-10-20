package ru.netology._auth_service.repository;

import org.springframework.stereotype.Repository;
import ru.netology._auth_service.entities.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private Map<Map<String, String>, List<Authorities>> userData = new ConcurrentHashMap<>();

    public UserRepository() {
        userData.put(Map.of("admin", "admin"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        userData.put(Map.of("user", "123"), List.of(Authorities.READ));
        userData.put(Map.of("noRuthorities", "123"), List.of());
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userData.containsKey(Map.of(user, password))) {
            return userData.get(Map.of(user, password));
        }
        return Collections.emptyList();
    }
}
