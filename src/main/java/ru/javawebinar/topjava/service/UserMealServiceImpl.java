package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

        @Autowired
        private UserMealRepository repository;

        public UserMeal save(UserMeal userMeal) {
                return repository.save(userMeal);
        }

        public void delete(int id) {
                repository.delete(id);
        }

        public UserMeal get(int id) throws NotFoundException {
                return repository.get(id);
        }

        public Collection<UserMeal> getAll() {
                return repository.getAll();
        }

        public List<UserMealWithExceed> getFilteredData(LocalDate dateFrom, LocalDate dateTo, LocalTime timeFrom, LocalTime timeTo, int calories) {
                return UserMealsUtil.getFilteredWithExceeded(repository.getFilteredData(dateFrom, dateTo), timeFrom, timeTo, calories);
        }

        public void update(UserMeal userMeal) {
                repository.save(userMeal);
        }
}



