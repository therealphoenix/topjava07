package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hp on 03.07.2016.
 */
@Transactional(readOnly = true)
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {


    @Transactional
    @Modifying
    UserMeal save(UserMeal userMeal, int userId);

    // false if meal do not belong to userId
    @Transactional
    @Modifying
    @Query(name = UserMeal.DELETE)
    int delete(@Param("id") int id, @Param("userId") int userId);



    @Query(name  = UserMeal.GET)
    UserMeal get(@Param("id") int id, @Param("userId") int userId);

    // ORDERED dateTime

    @Query(name = UserMeal.ALL_SORTED)
    List<UserMeal> findAll(@Param("userId") int  userId);

    // ORDERED dateTime
    @Query(name = UserMeal.GET_BETWEEN)
    List<UserMeal> getBetween(@Param("startDate") LocalDateTime startDate,
                                    @Param("endDate") LocalDateTime endDate,
                                    @Param("userId") int userId);
    @Query(name = UserMeal.ALL_FOR_USER)
   UserMeal getAllForUser(@Param("id")int id, @Param("user_id")int userId);
}



