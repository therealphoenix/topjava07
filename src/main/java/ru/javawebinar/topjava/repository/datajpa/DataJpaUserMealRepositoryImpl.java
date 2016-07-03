package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository{
    private static final Sort SORT_DATETIME = new Sort("dateTime");
    @Autowired
    private ProxyUserMealRepository proxyUserMeal;

    @Autowired
    private ProxyUserRepository proxyUser;

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        User ref = proxyUser.findOne(userId);
        userMeal.setUser(ref);
        if(userMeal.isNew()) {
            return proxyUserMeal.save(userMeal);
        } else {
            return proxyUserMeal.findOne(userMeal.getId(), userId) == null ? null : proxyUserMeal.save(userMeal);
        }
    }

    @Override
    public boolean delete(int id, int userId) {
        UserMeal userMeal = proxyUserMeal.findOne(id, userId);
        if (userMeal == null) return false;
        proxyUserMeal.delete(userMeal);
        return true;
    }


    @Override
    public UserMeal get(int id, int userId) {
        UserMeal userMeal = proxyUserMeal.findOne(id,userId);
        if(userMeal == null) return null;
        return userMeal;
    }

    @Override
    public List<UserMeal> getAll(int userId) {

        return proxyUserMeal.findAll(SORT_DATETIME,userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        List<UserMeal> result = new ArrayList<>(proxyUserMeal.getBetween(startDate,endDate,userId));
        return result;

            }

    public List<UserMeal> getAllForUser(int id, int userId){
        return proxyUserMeal.getAllForUser(id,userId);
    }
}
