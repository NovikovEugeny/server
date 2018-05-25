package by.bsuir.simpleserver.repository;

import by.bsuir.simpleserver.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private final static Map<Long, User> users = new HashMap<>();

    static {
        users.put(1L, new User(1, "James", "login1@gmail.com", "password1"));
        users.put(2L, new User(2, "Jim", "login2@gmail.com", "password2"));
        users.put(3L, new User(3, "Jack", "login3@gmail.com", "password3"));
        users.put(4L, new User(4, "Bruce", "login4@gmail.com", "password4"));
        users.put(5L, new User(5, "Bart", "login5@gmail.com", "password5"));
    }

    public static List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public static User findById(long id) {
        return users.get(id);
    }
}
