package controller;

import java.util.Optional;

import exception.UserNotFoundException;
import model.user.User;
import service.UserService;

public class AuthController {
    private final UserService userService = new UserService();

    public Optional<User> login(String email) {
        try {
            return userService.login(email);
        } catch (Exception e) {
            throw new UserNotFoundException("Email not found, please try again.");
        }
    }
}
