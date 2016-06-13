package ru.javawebinar.topjava.web.meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.service.UserMealServiceImpl;
import ru.javawebinar.topjava.util.MealsFilter;

import java.util.Collection;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    @Autowired
    private UserMealService service;


    public Collection<UserMeal> getAll() {
       return service.getAll();
    }

    public UserMeal get( int id) {
        return service.get(id);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void update(UserMeal userMeal) {
        service.save(userMeal);
    }

    public UserMeal create(UserMeal userMeal) {
        return service.save(userMeal);
    }

    public List<UserMealWithExceed> getFilteredData(MealsFilter mealsFilter, int calories) {
        return service.getFilteredData(mealsFilter.getDateFrom(), mealsFilter.getDateTo(), mealsFilter.getTimeFrom(), mealsFilter.getTimeTo(), calories);
    }


}


