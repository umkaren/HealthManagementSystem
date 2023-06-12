package org.health;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FoodLog {
    private List<FoodIntake> foodItems;
    private Scanner scanner;
    private static final String FOOD_FILE = "src/main/java/org/health/foodLog.txt";

    public FoodLog() {
        this.foodItems = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public List<FoodIntake> loadFood(User currentUser) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FOOD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                FoodIntake foodIntake = FoodIntake.fromStringWithDelimiters(line, currentUser);
                foodItems.add(foodIntake);
            }
        } catch (IOException e) {
            System.out.println("Error loading food log from file: " + e.getMessage());
        }
        return foodItems;
    }

    public void saveFood() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOOD_FILE))) {
            for (FoodIntake foodIntake : foodItems) {
                String line = foodIntake.toStringWithDelimiters();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving new food items: " + e.getMessage());
        }
    }

    public void addFood(User currentUser) {
        System.out.println("Food log details");
        System.out.println("Enter item name: ");
        String foodName = scanner.nextLine();

        if (foodName.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        double calories;
        try {
            System.out.println("How many calories are in this item?");
            calories = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        LocalDate currentDate = LocalDate.now();
        FoodIntake foodIntake = new FoodIntake(currentDate, currentUser, foodName, calories);
        foodItems.add(foodIntake);
        System.out.println("Food entry added successfully.");
    }

    public void displayAllFood() {
        if (foodItems.isEmpty()) {
            System.out.println("You have not logged any food items.");
        } else {
            System.out.println("Food Log: ");
            for (FoodIntake foodIntake : foodItems) {
                System.out.println("\nDate: " + foodIntake.getDate());
                System.out.println("Username: " + foodIntake.getUser());
                System.out.println("Food name: " + foodIntake.getFoodName());
                System.out.println("Calories: " + foodIntake.getCalories());
            }
        }
    }
}
