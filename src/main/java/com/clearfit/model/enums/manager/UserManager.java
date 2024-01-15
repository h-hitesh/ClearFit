package com.clearfit.model.enums.manager;

import com.clearfit.model.enums.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserManager {

    private static final UserManager instance = new UserManager();

    Map<String, User> users = new HashMap<>();
//    private final List<User> users = new ArrayList<>();

    private UserManager() {
    }

    public static UserManager getInstance() {
        return UserManager.instance;
    }

    public UUID addUser(String userName) {
        User user = new User(userName);
        this.users.put(userName, user);
        return user.getUserId();
    }

    public Optional<User> getUser(String userName) {
        return Optional.of(users.get(userName));
    }


}
