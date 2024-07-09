package domain.service;

import java.sql.SQLException;

import domain.entity.User;

public interface UserService {
    void createUser(User user);
    User findUserById(int id);
    int DeleteUserById(int id);
    void updatUserById(User user);
}
