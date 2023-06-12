package org.health;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<FoodIntake> foodLog;
    private List<ExerciseActivities> exerciseLog;
//    private List<SleepLog> sleepLog;

    public User(String username) {
        this.username = username;
        this.foodLog = new ArrayList<>();
        this.exerciseLog = new ArrayList<>();
//        this.sleepLog = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<FoodIntake> getFoodLog() {
        return foodLog;
    }

    public void addFoodIntake(FoodIntake foodIntake) {
        foodLog.add(foodIntake);
    }

    public List<ExerciseActivities> getExerciseLog() {
        return exerciseLog;
    }

    public void addExerciseActivity(ExerciseActivities exerciseActivities) {
        exerciseLog.add(exerciseActivities);
    }

//    public List<SleepLog> getSleepLog() {
//        return sleepLog;
//    }

//    public void addSleepLog(SleepLog sleepLogEntry) {
//        sleepLog.add(sleepLogEntry);
//    }
}
