package edu.aitu.oop3.user.repositories;

import edu.aitu.oop3.user.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
        System.out.println("[DB] User '" + user.getName() + "' has been successfully saved.");
    }

    public Optional<User> findById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}