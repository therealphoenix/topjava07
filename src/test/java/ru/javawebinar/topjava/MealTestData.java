package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static ru.javawebinar.topjava.model.BaseEntity.MEAL_SEQ;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {


    public static  int MEAL_ID = MEAL_SEQ;
    public static final int USER_ID = 100000;

    public static final UserMeal MEAL = new UserMeal(100003, LocalDateTime.parse("2016-06-20T06:22:26"), "Обед", 1000);


    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);

    public static class TestMeal extends UserMeal {


        public TestMeal(UserMeal um) {
            this(um.getId(), um.getDateTime(), um.getDescription(), um.getCalories());
        }


        public TestMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
            super(id, dateTime, description, calories);
        }

        public UserMeal asUserMeal() {
            return new UserMeal(this);
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestMeal that = (TestMeal) o;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.dateTime, that.dateTime)
                    && Objects.equals(this.description, that.description)
                    && Objects.equals(this.calories, that.calories);

        }

    }
}
