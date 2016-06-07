package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMeal {

    public void setId(int id) {
        this.id = id;
    }

    protected  int id;
    protected  LocalDateTime dateTime;
    protected  String description;
    protected  int calories;



    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }



    public UserMeal(LocalDateTime dateTime, String description, int calories) {

        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;

    }

    public LocalDateTime getDateTime() {

           return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public int getId() {
        return id;
    }
}
