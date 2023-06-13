package org.health;

import java.time.LocalDate;

class ExerciseActivities {
    private LocalDate date;

    private User user;
    private String type;
    private int duration;
    private double caloriesBurned;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public ExerciseActivities(LocalDate date, User user, String type, int duration, double caloriesBurned) {
        this.date = date;
        this.user = user;
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String toStringWithDelimiters() {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append("|");
        sb.append(user.getUsername()).append("|");
        sb.append(type).append("|");
        sb.append(duration).append("|");
        sb.append(caloriesBurned).append("|");
        return sb.toString();
    }

    //convert ExerciseActivities object from a string with delimiters
    public static ExerciseActivities fromStringWithDelimiters(String line, User currentUser) {
        String[] parts = line.split("\\|");
        if (parts.length != 5) {
            throw new IllegalStateException("Invalid format");
        }

        LocalDate date = LocalDate.parse(parts[0]);
        String type = parts[2];
        int duration = Integer.parseInt(parts[3]);
        double caloriesBurned = Double.parseDouble(parts[4]);

        return new ExerciseActivities(date, currentUser, type, duration, caloriesBurned);
    }
}
