package com.clearfit.model.enums.manager;


import com.clearfit.model.enums.model.Session;
import com.clearfit.model.enums.model.User;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private static final SessionManager SESSION_MANAGER = new SessionManager();

    private final Map<User, Session> bookings = new HashMap<>();

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        return SESSION_MANAGER;
    }

    public void bookSession(User user, Session session) {
        bookings.put(user, session);
    }

    public void cancelSession(User user, Session session) {
        bookings.remove(user, session);
    }
}
