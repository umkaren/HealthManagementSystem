package org.health;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthManagementSystem {
    public static void main(String[] args) {
        UserLog userLog = new UserLog();
        User currentUser = null;

        userLog.loadUsers();
        SleepLog sleepLog = new SleepLog();
        FoodLog foodLog = new FoodLog();
        ExerciseLog exerciseLog = new ExerciseLog();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Healthy Habits!");
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        if (userLog.login(username)) {
            currentUser = userLog.getCurrentUser();
            System.out.println("Welcome back, " + currentUser.getUsername());
            sleepLog.loadSleep(currentUser);
            foodLog.loadFood(currentUser);
            exerciseLog.loadExercise(currentUser);
        } else {
            System.out.println("Username hasn't been claimed. Creating a new account.");
            currentUser = new User(username);
            userLog.saveUsers();
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
                    foodLog.addFood(currentUser);
                    foodLog.saveFood();
                    break;
                case 2:
                    exerciseLog.addExercise(currentUser);
                    exerciseLog.saveExercise();
                    break;
                case 3:
                    sleepLog.addSleep(currentUser);
                    sleepLog.saveSleep();
                    break;
                case 4:
//                    double calorieBalance = calculateDailyCalorieBalance(foodLog, exerciseLog);
//                    System.out.println("Daily Calorie Balance: " + calorieBalance + " calories.");
                    break;
                case 5:
                    sleepAnalysis(sleepLog);
                    break;
                case 6:
                    exerciseLog.displayAllActivities();
                    break;
                case 7:
                    generateHealthSummary(foodLog, exerciseLog, sleepLog);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        userLog.saveUsers();
    }
//    private static double calculateDailyCaloricBalance(FoodLog foodLog, ExerciseLog exerciseLog) {
//        double consumedCalories = foodLog.calculateTotalCalories();
//        double burnedCalories = exerciseLog.calculateTotalCalories();
//        return consumedCalories - burnedCalories;
//    }

    private static void sleepAnalysis(SleepLog sleepLog) {
        double averageSleepDuration = sleepLog.calculateAverageSleepDuration();
        System.out.println("Average Sleep Duration: " + averageSleepDuration + " hours");
    }

    private static void generateHealthSummary(FoodLog foodLog, ExerciseLog exerciseLog, SleepLog sleepLog) {
//        double consumedCalories = foodLog.calculateTotalCalories();
//        double burnedCalories = exerciseLog.calculateTotalCalories();
        double averageSleepDuration = sleepLog.calculateAverageSleepDuration();

        System.out.println("Health Summary for " + LocalDate.now());
//        System.out.println("Caloric Intake: " + consumedCalories + " calories");
//        System.out.println("Calories Burned: " + burnedCalories + " calories");
        System.out.println("Average Sleep Duration: " + averageSleepDuration + " hours");
    }
}
