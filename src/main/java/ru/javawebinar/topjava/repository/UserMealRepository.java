package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {
    UserMeal save(UserMeal userMeal);

    boolean delete(int id);

    UserMeal get(int id);

    Collection<UserMeal> getAll();
    List <UserMeal> getFilteredData(LocalDate dateFrom, LocalDate dateTo);
}
