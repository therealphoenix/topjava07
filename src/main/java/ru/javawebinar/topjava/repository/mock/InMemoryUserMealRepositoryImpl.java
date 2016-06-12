package ru.javawebinar.topjava.repository.mock;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::save);
    }


    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;

        for( Map.Entry<Integer, UserMeal> entry : repository.entrySet() ) {
            if (id == (entry.getKey()))
                repository.remove(id);
                result = true;
        }
        return result;
    }

    @Override
    public UserMeal get(int id) {
        int result = 0;

        for( Map.Entry<Integer, UserMeal> entry : repository.entrySet() ) {
            if (id == (entry.getKey()))
                result = id;
        }
        if(result == 0)
            return repository.get(result);
        else
        return null;
    }

    @Override
    public Collection<UserMeal> getAll() {

        Comparator comparator = new SortedByDate();
        List<UserMeal> mealList = new ArrayList<>(repository.values());

        Collections.sort(mealList,comparator);
        Collections.reverse(mealList);
        return mealList;
    }

    class SortedByDate implements Comparator<UserMeal> {

        public int compare(UserMeal obj1, UserMeal obj2) {

            String str1 = obj1.getDateTime().toString();
            String str2 = obj2.getDateTime().toString();

            return str1.compareTo(str2);
        }


    }
}

