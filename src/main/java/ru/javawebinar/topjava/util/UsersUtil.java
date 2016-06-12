package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Hp on 12.06.2016.
 */
public class UsersUtil {
    public static final List<User> USER_LIST = Arrays.asList(
            new User(1, "Jack", "jack@gmail.com", "root", Role.ROLE_ADMIN),
            new User(2, "Jill", "jellyj@yahoo.com", "ghtd", Role.ROLE_USER),
            new User(3, "Johny", "johny@tut.by", "youmaynotpass", Role.ROLE_ADMIN),
            new User(4, "Rebecca", "rebel@gmail.com", "face2face", Role.ROLE_ADMIN),
            new User(5, "Alex", "alex@tut.by", "pasport", Role.ROLE_ADMIN),
            new User(6, "David", "silva@gmail.com", "esmagico", Role.ROLE_ADMIN),
            new User(7, "Willy", "chilly@email.by", "penguin", Role.ROLE_ADMIN)

    );

}
