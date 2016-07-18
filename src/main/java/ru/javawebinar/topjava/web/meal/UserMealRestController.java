package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.UserMeal;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@RestController
@RequestMapping(UserMealRestController.REST_URL)
public class UserMealRestController extends AbstractUserMealController {
    static final String REST_URL = "/rest/meals";


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserMeal get(@PathVariable("id") Integer id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }

    //r
@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getAll() {
        return super.getAll();
    }
//
@RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserMeal meal,@PathVariable("id") int id) {
        meal.setId(id);
        int userId = AuthorizedUser.id();
        super.update(meal, userId);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserMeal create(@RequestBody UserMeal meal) {
        return super.create(meal);
    }
    @RequestMapping(path = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getBetween(@RequestBody LocalDate startDate, @RequestBody LocalTime startTime,
                                               @RequestBody LocalDate endDate, @RequestBody LocalTime endTime) {
          return super.getBetween(startDate,startTime,endDate,endTime);
    }
}