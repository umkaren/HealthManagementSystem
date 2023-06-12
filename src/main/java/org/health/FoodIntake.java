package org.health;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

class FoodIntake {
    private LocalDate date;
    private User user;
    private String foodName;
    private double calories;

    public FoodIntake(LocalDate date, User user, String foodName, double calories) {
        this.date = date;
        this.user = user;
        this.foodName = foodName;
        this.calories = calories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //convert FoodIntake to a string with delimiters
    public String toStringWithDelimiters() {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append("|");
        sb.append(user.getUsername()).append("|");
        sb.append(foodName).append("|");
        sb.append(calories).append("|");
        return sb.toString();
    }

    //convert FoodIntake object from a string with delimiters
    public static FoodIntake fromStringWithDelimiters(String line, User currentUser) {
        String[] parts = line.split("\\|");
        if (parts.length != 4) {
            throw new IllegalStateException("Invalid format");
        }

        LocalDate date = LocalDate.parse(parts[0]);
        String foodName = parts[2];
        double calories = Double.parseDouble(parts[3]);
        return new FoodIntake(date, currentUser, foodName, calories);
    }
}


