package ru.javawebinar.topjava.repository.datajpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.service.UserService;

import java.util.Collections;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN;
import static ru.javawebinar.topjava.UserTestData.MATCHER;
import static ru.javawebinar.topjava.UserTestData.USER_ID;


/**
 * Created by Hp on 03.07.2016.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(Profiles.ACTIVE_DB)

public class DataJpaUserRepositoryImplTest {

    @Autowired
    protected DataJpaUserRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository.evictCache();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        repository.delete(USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), repository.getAll());

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getByEmail() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

}