package controller;

import model.User;

import java.util.HashMap;

public class UserServiceImpl implements UserService{
    HashMap<String, User> users = new HashMap<>();

    public HashMap<String, User> getUsers() {
        return users;
    }

    private int counter = 0;
    @Override
    public void addUser(User user) {
        users.put(String.valueOf(counter++), user);
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public User editUser(String id, User user) {
        users.put(id, user);
        return users.get(id);
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    @Override
    public Boolean userExist(String id) {
        return users.get(id) != null;
    }
}
