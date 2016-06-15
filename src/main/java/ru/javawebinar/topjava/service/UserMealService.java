package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * GKislin
 * 15.06.2015.
 */

public interface UserMealService {


    void delete(int id);

    UserMeal get (int id);
    UserMeal save(UserMeal userMeal);
    void update(UserMeal userMeal);

    Collection<UserMeal> getAll();

    List<UserMealWithExceed> getFilteredData(LocalDate dateFrom, LocalDate dateTo,
                                             LocalTime timeFrom, LocalTime timeTo, int calories);
}
