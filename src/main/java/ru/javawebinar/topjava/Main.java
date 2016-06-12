package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.mock.InMemoryUserMealRepositoryImpl;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl;
import ru.javawebinar.topjava.util.UsersUtil;

import java.time.LocalDateTime;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello Topjava Enterprise!");

      // System.out.println(new InMemoryUserRepositoryImpl().getAll());

        InMemoryUserMealRepositoryImpl meal = new InMemoryUserMealRepositoryImpl();

        meal.save(new UserMeal(LocalDateTime.now(),"Полдник", 1000));
      //  System.out.println(new InMemoryUserMealRepositoryImpl().getAll());
        System.out.println(meal.getAll());

    }
}
