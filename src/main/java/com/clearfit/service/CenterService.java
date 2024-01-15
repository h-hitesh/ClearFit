package com.clearfit.service;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.model.Slot;

import java.util.List;

public interface CenterService {
    boolean addCenter(String name);

    void addCenterActivities(String name, List<Activity> activities);

    void addCenterTimings(String name, List<Slot> slots);
}
