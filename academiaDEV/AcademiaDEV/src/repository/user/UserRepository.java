package repository.user;

import model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public List<User> findAll();
    public Optional<User> findByEmail(String email);
    public void deleteUser(String email);
    public User updateUser(User user);
}
