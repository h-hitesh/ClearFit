package com.clearfit.model.enums.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class User {

    private UUID userId;
    private String name;

    private List<Session> session = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Session> getSession() {
        return session;
    }

    public void addSession(Session session) {
        this.session.add(session);
    }

    public Optional<Session> getSession(String centerName, String activityName, Slot slot) {
        return session.stream().filter(s -> s.getCenterName().equals(centerName) && s.getActivity().getName().equals(activityName) && s.getActivity().getSlot().equals(slot)).findFirst();
    }
}
