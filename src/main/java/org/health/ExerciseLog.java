package org.health;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciseLog {
    private List<ExerciseActivities> activities;
    Scanner scanner;
    private String Exercise_File;
    private User currentUser;

    public ExerciseLog() {
        this.activities = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.Exercise_File = "src/main/java/org/health/exerciseLog.txt";
    }

    public List<ExerciseActivities> loadExercise(User currentUser) {
        try {
            File file = new File(this.Exercise_File);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                activities.clear();

                String line;
                while((line = reader.readLine()) != null) {
                    ExerciseActivities exerciseActivities = ExerciseActivities.fromStringWithDelimiters(line, currentUser);
                    activities.add(exerciseActivities);
                }

                reader.close();
                return activities;
            }
        } catch (IOException loadExercisetxt) {
            System.out.println("Error loading exercise log from file: " + loadExercisetxt.getMessage());
        }
        return null;
    }

    public void saveExercise() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.Exercise_File));

            for(int i = 0; i <activities.size(); ++i) {
                ExerciseActivities exerciseActivities = activities.get(i);
                String line = exerciseActivities.toStringWithDelimiters();
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException saveExercisetxt) {
            System.out.println("Error saving new exercise logs: " + saveExercisetxt.getMessage());
        }
    }

    public void addExercise(User currentUser) {
        System.out.println("Exercise log details");
        System.out.println("Enter exercise type: ");
        String exerciseType = this.scanner.nextLine();

        if (exerciseType.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        int duration;
        try {
            System.out.println("How long was this exercise?");
            duration = Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        double caloriesBurned;
        try {
            System.out.println("Approximately how many calories did you burn?");
            caloriesBurned = Double.parseDouble(this.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        LocalDate date = LocalDate.now();
        if(currentUser != null) {
            ExerciseActivities exerciseActivities = new ExerciseActivities(date, currentUser, exerciseType, duration, caloriesBurned);
            currentUser.addExerciseActivity(exerciseActivities);
            activities.add(exerciseActivities);
            System.out.println("New exercise logged successfully.");
        }
    }

    public void displayAllActivities() {
        if (activities.isEmpty()) {
            System.out.println("You have not logged any exercise activities.");
        } else {
            System.out.println("Exercise Log: ");
            Iterator exerciseIterator = activities.iterator();

            while (exerciseIterator.hasNext()) {
                ExerciseActivities exerciseActivities = (ExerciseActivities) exerciseIterator.next();
                System.out.println("\n Date: " + exerciseActivities.getDate());
                System.out.println("Username: " + exerciseActivities.getUser());
                System.out.println("Exercise name: " + exerciseActivities.getType());
                System.out.println("Duration: " + exerciseActivities.getDuration());
                System.out.println("Calories Burned: " + exerciseActivities.getCaloriesBurned());
            }
        }
    }
}
