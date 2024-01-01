package user;

public class UserService {
    private final UserDao userDao = new UserDao();

    public User[] getAllUsers() {
        return userDao.getAllUsers();
    }
}
