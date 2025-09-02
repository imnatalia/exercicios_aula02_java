package service;

import java.util.List;
import java.util.Optional;

import model.user.User;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new InMemoryUserRepository();
    }

    public Optional<User> login(String email) {
        return userRepository.findByEmail(email);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
}