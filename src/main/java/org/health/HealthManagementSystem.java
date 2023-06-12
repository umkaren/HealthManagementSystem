package org.health;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthManagementSystem {
    public static void main(String[] args) {
        UserLog userLog = new UserLog();
        User currentUser = null;

        userLog.loadUsers();
//        SleepLog sleepLog = new SleepLog();
        FoodLog foodLog = new FoodLog();
        Ex

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Healthy Habits!");
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        if (userLog.login(username)) {
            currentUser = userLog.getCurrentUser();
            System.out.println("Welcome back, " + currentUser.getUsername());
        } else {
            System.out.println("Username hasn't been claimed. Creating a new account.");
            currentUser = new User(username);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nLogged in as: " + currentUser.getUsername());
            System.out.println("Menu:");
            System.out.println("1. Add food log");
            System.out.println("2. Add exercise log");
            System.out.println("3. Add sleep log");
            System.out.println("4. Daily caloric balance");
            System.out.println("5. Sleep analysis");
            System.out.println("6. Exercise log");
            System.out.println("7. Health Summary");
            System.out.println("8. Log out");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    foodLog.addFood();
                    break;
                case 2:
                    exerciseLog.addExercise();
                    break;
                case 3:

                case 4:
                    // Implement Daily Caloric Balance
                    break;
                case 5:
                    // Implement Sleep Analysis
                    break;
                case 6:
                    exerciseLog.displayAllActivities();
                    break;
                case 7:
                    // Implement Health Summary
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }

        }

    }
}
