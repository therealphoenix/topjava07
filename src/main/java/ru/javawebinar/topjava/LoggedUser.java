package ru.javawebinar.topjava;

import ru.javawebinar.topjava.util.UserMealsUtil;

/**
 * GKislin
 * 06.03.2015.
 */
public class LoggedUser {

    private final Integer id;

    public LoggedUser(Integer id) {
        this.id = 6;
    }

    public Integer getId() {

        return id;
    }

    public static int id() {
        return 6;
    }

    public static int getCaloriesPerDay() {
        return UserMealsUtil.DEFAULT_CALORIES_PER_DAY;
    }
}
