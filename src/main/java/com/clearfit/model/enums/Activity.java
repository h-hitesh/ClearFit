package com.clearfit.model.enums;

import com.clearfit.model.enums.model.Slot;

public class Activity {
    private String name;
    private Slot slot;

    private int available;

    public Activity(String activity) {
        this.name = activity.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
