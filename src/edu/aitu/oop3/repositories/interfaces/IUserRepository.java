package edu.aitu.oop3.repositories.interfaces;

import edu.aitu.oop3.entities.User;
import java.util.List;

public interface IUserRepository {
    void add(User user);
    User findById(int id);
    List<User> findAll();
}