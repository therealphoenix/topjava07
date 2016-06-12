package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.UsersUtil;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private List<User> repository = new ArrayList<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UsersUtil.USER_LIST.forEach(this::save);
    }

    @Override
    public User save(User user) {

        user.setId(counter.incrementAndGet());

        repository.add(user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;

        for (User u : repository) {
            if (u.getId() == id) {
                repository.remove(u);
                result = true;
            }
        }
        return result;

    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        for (User u : repository) {
            if (u.getEmail().equals(email)) {
                result = u;

            }
        }
        return result;

    }

    @Override
    public User get(int id) {
        User result = null;
        for (User u : repository) {
            if (u.getId() == id) {
                result = u;
            }
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        Comparator comparator = new SortedByName();
        Collections.sort(repository, comparator);
        return repository;
    }

    class SortedByName implements Comparator<User> {

        public int compare(User obj1, User obj2) {

            String str1 = obj1.getName();
            String str2 = obj2.getName();

            return str1.compareTo(str2);
        }


    }
}
