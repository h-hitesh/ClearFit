package com.clearfit.model.enums.response;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.model.Slot;

public class WorkoutAvailabilityResponse {

    private String centerName;
    private Activity activity;

    private Slot slot;

    public WorkoutAvailabilityResponse(String centerName, Activity activity, Slot slot) {
        this.centerName = centerName;
        this.activity = activity;
        this.slot = slot;
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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
