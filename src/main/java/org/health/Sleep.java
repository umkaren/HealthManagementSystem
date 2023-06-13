package org.health;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Sleep {
    private LocalDate date;

    private String username;
    private String nightyTime;
    private String wakeyTime;

    public Sleep(LocalDate date, String username, String nightyTime, String wakeyTime) {
        this.date = LocalDate.now();
        this.username = username;
        this.nightyTime = nightyTime;
        this.wakeyTime = wakeyTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNightyTime() {
        return nightyTime;
    }

    public void setNightyTime(String nightyTime) {
        this.nightyTime = nightyTime;
    }

    public String getWakeyTime() {
        return wakeyTime;
    }

    public void setWakeyTime(String wakeyTime) {
        this.wakeyTime = wakeyTime;
    }

    public String toStringWithDelimiters() {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append("|");
        sb.append(username).append("|");
        sb.append(nightyTime).append("|");
        sb.append(wakeyTime).append("|");
        return sb.toString();
    }

    //convert Sleep object from a string with delimiters
    public static Sleep fromStringWithDelimiters(String line, User currentUser) {
        String[] parts = line.split("\\|");
        if (parts.length != 4) {
            throw new IllegalStateException("Invalid format");
        }

        LocalDate date = LocalDate.parse(parts[0]);
        String username = parts[1];
        String nightyTime = parts[2];
        String wakeyTime = parts[3];

        return new Sleep(date, username, nightyTime, wakeyTime);
    }

    public double calculateSleepDuration() {
        LocalTime nightTime = LocalTime.parse(this.nightyTime);
        LocalTime wakeyTime = LocalTime.parse(this.wakeyTime);

        return nightTime.until(wakeyTime, ChronoUnit.HOURS);
    }
}
