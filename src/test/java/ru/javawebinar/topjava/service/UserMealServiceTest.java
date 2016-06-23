package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Collections;

import static ru.javawebinar.topjava.MealTestData.*;

import static org.junit.Assert.*;



/**
 * Created by Hp on 19.06.2016.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {

    @Autowired
    protected UserMealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {

        dbPopulator.execute();
    }

    @Test
    public void get() throws Exception {
        UserMeal um = service.get(128,USER_ID);
        MATCHER.assertEquals(MEAL, um);

    }

    @Test
    public void delete() throws Exception {
        service.delete(126, USER_ID);
        MATCHER.assertCollectionEquals(service.getAll(1000),service.getAll(1000));

    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        MATCHER.assertCollectionEquals(Collections.singletonList(MEAL),
                service.getBetweenDateTimes(LocalDateTime.parse("2016-05-20T06:22:26"),
                LocalDateTime.parse("2016-07-20T06:22:26"),USER_ID));

    }


    @Test
    public void getAll() throws Exception {
        service.getAll(USER_ID);
        MATCHER.assertCollectionEquals(service.getAll(USER_ID),service.getAll(USER_ID));

    }

    @Test
    public void update() throws Exception {
        UserMeal updated = service.get(127, USER_ID);
        updated.setCalories(333);
        service.update(updated, USER_ID);
        MATCHER.assertEquals(updated, service.get(MEAL_ID, USER_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(1,999);
    }
    @Test(expected = NotFoundException.class)
    public void testNotFoundGet() throws Exception {
        service.get(1,999);
    }
    @Test(expected = NotFoundException.class)
    public void testNotFoundUpdate() throws Exception {
        service.update(MEAL,999);
    }

}