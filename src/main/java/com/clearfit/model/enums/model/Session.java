package com.clearfit.model.enums.model;

import com.clearfit.model.enums.Activity;

import java.util.UUID;

public class Session {
    private UUID sessionId;
    private UUID userId;
    private String centerName;
    private Activity activity;

    public Session(UUID userId, String centerName, Activity activity) {
        this.sessionId = UUID.randomUUID();
        this.userId = userId;
        this.centerName = centerName;
        this.activity = activity;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
