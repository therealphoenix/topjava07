package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.TestUtil;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.web.AbstractControllerTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.USER_ID;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;
import static ru.javawebinar.topjava.web.meal.UserMealRestControllerTest.REST_MEAL_URL;
import ru.javawebinar.topjava.LoggedUser;

/**
 * Created by Hp on 17.07.2016.
 */
@RequestMapping(REST_MEAL_URL)
public class UserMealRestControllerTest extends AbstractControllerTest {

    static final String REST_MEAL_URL = "/rest/meals/";
    @Test
    public void testGet() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_MEAL_URL + (START_SEQ + 2)).contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MEAL_MATHCER.contentMatcher(MEAL1));

    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_MEAL_URL + (START_SEQ + 2)))
                .andExpect(status().isOk());
        MEALEX_MATHCER.assertCollectionEquals(EUSER_MEALS, UserMealsUtil.getWithExceeded(userMealService.getAll(LoggedUser.id), LoggedUser.getCaloriesPerDay()));

    }

    @Test
    public void TestGetAll() throws Exception {

            TestUtil.print(mockMvc.perform(get(REST_MEAL_URL))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MEALEX_MATHCER.contentListMatcher(UserMealsUtil.getWithExceeded(userMealService.getAll(LoggedUser.id), LoggedUser.getCaloriesPerDay()))));

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void getBetween() throws Exception {

    }

}