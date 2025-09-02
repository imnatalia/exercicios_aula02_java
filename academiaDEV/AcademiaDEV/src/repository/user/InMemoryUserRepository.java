package repository.user;

import model.user.User;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }

    @Override
    public void deleteUser(String email) {
        users.remove(email);
    }

    @Override
    public User updateUser(User user) {
        return users.replace(user.getEmail(), user);
    }
}
