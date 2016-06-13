package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hp on 12.06.2016.
 */

public class MockUserMealRepositoryImpl implements UserMealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserMealRepositoryImpl.class);


    @Override
    public List<UserMeal> getFilteredData(LocalDate dateFrom, LocalDate dateTo) {
        LOG.info("do Filter");
        return null;
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        LOG.info("save" + userMeal);
        return userMeal;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return true;

    }

    @Override
    public UserMeal get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public Collection<UserMeal> getAll() {
        LOG.info("getAll" );
        return Collections.emptyList();
    }
}
