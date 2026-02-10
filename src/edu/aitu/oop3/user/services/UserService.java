package edu.aitu.oop3.user.services;

import edu.aitu.oop3.user.models.User;
import edu.aitu.oop3.user.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerNewUser(int id, String name, String email) {
        if (name == null || name.isEmpty()) {
            System.out.println("[Error] User name cannot be empty!");
            return;
        }

        User user = new User(id, name, email);
        userRepository.save(user);
        System.out.println("[Service] Registration completed for: " + name);
    }
}