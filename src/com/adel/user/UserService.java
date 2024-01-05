package com.adel.user;

public class UserService {
    private static final UserDao userDao = new UserDao();

    public User[] getAllUsers() {
        return userDao.getAllUsers();
    }
}
