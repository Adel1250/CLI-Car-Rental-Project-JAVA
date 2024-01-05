package com.adel.user;

public class UserDao {
    private static final User[] users;

    static {
        users = new User[] {
                new User("Adel", "af3bc19e-a12d-4979-b2ed-afee2325ad4b"),
                new User("Ashraf", "3d417cc8-feb4-4b87-8988-5541e71bb145")
        };
    }

    public User[] getAllUsers() {
        return users;
    }
}
