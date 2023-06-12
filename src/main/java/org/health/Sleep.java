//package org.health;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//public class Sleep {
//    private LocalDate date;
//
//    private String username;
//    private LocalTime nightyTime;
//    private LocalTime wakeyTime;
//
//    public Sleep(LocalDate date, String username, LocalTime nightyTime, LocalTime wakeyTime) {
//        this.date = LocalDate.now();
//        this.username = username;
//        this.nightyTime = nightyTime;
//        this.wakeyTime = wakeyTime;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public LocalTime getNightyTime() {
//        return nightyTime;
//    }
//
//    public void setNightyTime(LocalTime nightyTime) {
//        this.nightyTime = nightyTime;
//    }
//
//    public LocalTime getWakeyTime() {
//        return wakeyTime;
//    }
//
//    public void setWakeyTime(LocalTime wakeyTime) {
//        this.wakeyTime = wakeyTime;
//    }
//
//    public String toStringWithDelimiters() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(date).append("|");
//        sb.append(username).append("|");
//        sb.append(nightyTime).append("|");
//        sb.append(wakeyTime).append("|");
//        return sb.toString();
//    }
//
//    //convert Sleep object from a string with delimiters
//    public static SleepLog fromStringWithDelimiters(String line) {
//        String[] parts = line.split("\\|");
//        if (parts.length != 4) {
//            throw new IllegalStateException("Invalid format");
//        }
//
//        LocalDate date = LocalDate.parse(parts[0]);
//        String username = parts[1];
//        LocalTime nightyTime = LocalTime.parse(parts[2]);
//        LocalTime wakeyTime = LocalTime.parse(parts[3]);
//
//        return new SleepLog(date, username, nightyTime, wakeyTime);
//    }
//}
