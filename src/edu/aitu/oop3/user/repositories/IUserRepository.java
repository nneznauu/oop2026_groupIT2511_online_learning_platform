package edu.aitu.oop3.user.repositories;

import edu.aitu.oop3.user.models.User;
import java.util.List;

public interface IUserRepository {
    void add(User user);
    User findById(int id);
    List<User> findAll();
}