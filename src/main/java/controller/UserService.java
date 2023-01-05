package controller;

import model.User;

public interface UserService {
    void addUser(User user);
    User getUser(String id);
    User editUser(String id, User user);
    void deleteUser(String id);
    Boolean userExist(String id);
}
