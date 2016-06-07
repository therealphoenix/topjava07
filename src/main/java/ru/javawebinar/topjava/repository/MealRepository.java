package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by Hp on 07.06.2016.
 */
public interface MealRepository {

    void add(UserMeal userMeals);
    void edit(int id, UserMeal userMeals);
    void addAll(List<UserMeal> userMealList);
    void remove(int id);
    UserMeal getById(int id);
    List<UserMeal> getAll();


}
