package com.adel.user;

import java.io.*;
import java.util.Scanner;

public class UserArrayDataAccessService implements UserDao {
    private static final User[] users;
    private static int usersCount;

    static {
        users = new User[50];
        readCSVFile();
        usersCount = 0;
    }

    @Override
    public User[] getAllUsers() {
        return users;
    }

    private static void readCSVFile() {
        File file = new File("src/com/adel/users.csv");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Users file is created successfully!");
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Can't create the file!");
        }
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            String[] userLineValues = scanner.nextLine().split(", ");
            User user = new User(userLineValues[0], userLineValues[1]);
            users[usersCount] = user;
            usersCount++;
            if (usersCount == 50) {
                usersCount = 0;
            }
        }
    }
}
