package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcUserMealRepositoryImpl implements UserMealRepository {

    private static final BeanPropertyRowMapper<UserMeal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(UserMeal.class);

    @Autowired
     private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertUserMeal;

    @Autowired
    public JdbcUserMealRepositoryImpl(@Qualifier("dataSource") DataSource dataSource) {
        this.insertUserMeal = new SimpleJdbcInsert(dataSource)
                .withTableName("MEALS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", userMeal.getId())
                .addValue("user_id", userId)
                .addValue("datetime", Timestamp.valueOf(userMeal.getDateTime()))
                .addValue("description", userMeal.getDescription())
                .addValue("calories", userMeal.getCalories());

        if (userMeal.isNew()) {
            Number newKey = insertUserMeal.executeAndReturnKey(map);
            userMeal.setId(newKey.intValue());
        } else {
            int affected = namedParameterJdbcTemplate.update(
                    "UPDATE meals SET datetime=:datetime, description=:description, calories=:calories WHERE id=:id AND user_id=:user_id", map);
            return affected == 0 ? null : userMeal;
        }
        return userMeal;
    }
    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM meals WHERE (id=? AND user_id=?)", id,userId) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {

        List<UserMeal> meals = jdbcTemplate.query("SELECT * FROM meals WHERE (id=? AND user_id=?)", ROW_MAPPER, id, userId);
        return DataAccessUtils.singleResult(meals);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return jdbcTemplate.query("SELECT * FROM meals WHERE user_id=? ORDER BY datetime DESC", ROW_MAPPER, userId);

    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {

        return jdbcTemplate.query("SELECT * FROM meals WHERE (user_id=? AND datetime BETWEEN ? AND ?) ORDER BY datetime DESC",
                ROW_MAPPER, userId, startDate, endDate);
    }
}
