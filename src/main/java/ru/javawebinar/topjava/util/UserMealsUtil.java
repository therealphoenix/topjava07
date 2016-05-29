package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

            List<UserMealWithExceed> listOfTheTime = new ArrayList<>();

            // makin' map(Day, counting  calories for this day) with stream API

            Map<LocalDate, Integer> listOfTheDay = mealList.stream()
                    .collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(), // grouping by day
                            Collectors.summingInt(UserMeal::getCalories))); // summing all calories for current group

            //makin' list of dishes choosen by time

      mealList.stream()
                  .filter(t -> TimeUtil.isBetween(t.getDateTime().toLocalTime(),startTime,endTime)) // filtering list by time
                  .forEach(i-> listOfTheTime.
                  add( new UserMealWithExceed(i.getDateTime(),i.getDescription() // adding new user to resulting list
                         ,i.getCalories(),listOfTheDay.get(i.getDateTime().toLocalDate()) > caloriesPerDay)));

            return  listOfTheTime;
        }
/*
        // w/o stream api, using foreach in foreach

    List<UserMealWithExceed> listOftheTime = new ArrayList<>();
    for (UserMeal um : mealList) {

    // counting calories for day
        int calories = 0;
        for (UserMeal listOfTheDay : mealList) {
            if (um.getDateTime().toLocalDate().equals(listOfTheDay.getDateTime().toLocalDate()))
                calories = calories + listOfTheDay.getCalories();
        }

        // making makin' list of dishes choosen by time
        if (TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime)) {
            timeList.add(new UserMealWithExceed(um.getDateTime(), um.getDescription(),
             um.getCalories(), calories > caloriesPerDay));
        }
    }
    return listOfTheTime;
*/

    }

