package java_web.ss06bt.service;

import java_web.ss06bt.entity.Book;
import java_web.ss06bt.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
