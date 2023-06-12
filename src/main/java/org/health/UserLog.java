package org.health;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserLog {
    private List<User> users;
    private User currentUser;
    private static final String User_File = "src/main/java/org/health/users.txt";

    public UserLog() {
        users = new ArrayList<>();
    }

    public boolean login(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(User_File))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String username = line.trim();
                User user = new User(username);
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    public void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(User_File))) {
            for (User user : users) {
                writer.write(user.getUsername());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }
}
