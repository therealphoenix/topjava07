package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

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
                ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
        }

        public UserMeal get(int id) throws NotFoundException {
                return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
        }

        public Collection<UserMeal> getAll() {
                return repository.getAll();
        }

        public void update(UserMeal userMeal) {
                repository.save(userMeal);
        }
}



