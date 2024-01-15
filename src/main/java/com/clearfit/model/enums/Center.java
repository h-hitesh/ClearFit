package com.clearfit.model.enums;

import com.clearfit.model.enums.model.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Center {

    private String name;

    private final Map<String, Activity> activities = new HashMap<>();

    private List<Slot> centerTime;

    public Center() {
    }

    public Center(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Activity> getActivities() {
        return activities;
    }

    public Optional<Activity> getActivityByName(String activityName) {
        return Optional.of(activities.getOrDefault(name, new Activity(activityName)));
    }

    public void addActivities(Activity activity) {

        activities.put(activity.getName(), activity);
    }

    public void addActivities(String activityName, Slot slot, int availableSlots) {
        Activity activity = activities.getOrDefault(activityName, null);
        if (activity == null) {
            throw new RuntimeException("Activity Not Found");
        }
        boolean validStart = false, validEnd = false;
        if (centerTime != null) {
            for (Slot s : centerTime) {
                if (!validStart && s.getStart() > slot.getStart() && s.getEnd() < slot.getEnd())
                    validStart = true;
                if (!validEnd && s.getEnd() > slot.getEnd() && s.getStart() < slot.getEnd())
                    validEnd = true;

            }
            if (!validEnd || !validStart) {
                throw new RuntimeException("Unable to add slot");
            }
        }
        activity.setSlot(slot);
        activity.setAvailable(availableSlots);
        this.activities.putIfAbsent(activityName, activity);
    }

    public List<Slot> getCenterTime() {
        return centerTime;
    }

    public void setCenterTime(List<Slot> centerTime) {
        this.centerTime = centerTime;
    }
}
