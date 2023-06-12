package org.health;

import java.time.LocalDate;

class ExerciseActivities {
    private LocalDate date;

    private String username;
    private String type;
    private int duration;
    private double caloriesBurned;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public ExerciseActivities(LocalDate date, String username, String type, int duration, double caloriesBurned) {
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String toStringWithDelimiters() {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append("|");
        sb.append(username);
        sb.append(type).append("|");
        sb.append(duration).append("|");
        sb.append(caloriesBurned).append("|");
        return sb.toString();
    }

    //convert ExerciseActivities object from a string with delimiters
    public static ExerciseActivities fromStringWithDelimiters(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 5) {
            throw new IllegalStateException("Invalid format");
        }

        LocalDate date = LocalDate.parse(parts[0]);
        String username = parts[1];
        String type = parts[2];
        int duration = Integer.parseInt(parts[3]);
        double caloriesBurned = Double.parseDouble(parts[4]);

        return new ExerciseActivities(date, username, type, duration, caloriesBurned);
    }
}
