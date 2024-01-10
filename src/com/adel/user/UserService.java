package com.adel.user;

public class UserService {
    private static final UserArrayDataAccessService USER_ARRAY_DATA_ACCESS_SERVICE = new UserArrayDataAccessService();

    public User[] getAllUsers() {
        return USER_ARRAY_DATA_ACCESS_SERVICE.getAllUsers();
    }
}
