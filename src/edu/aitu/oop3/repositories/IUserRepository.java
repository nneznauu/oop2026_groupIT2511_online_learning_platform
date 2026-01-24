package edu.aitu.oop3.repositories;

import edu.aitu.oop3.entities.User;
import java.util.List;

public interface IUserRepository {
    boolean create(User user);
    List<User> findAll();
    User findById(int id);
}