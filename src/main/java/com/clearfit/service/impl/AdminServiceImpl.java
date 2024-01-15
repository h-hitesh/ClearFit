package com.clearfit.service.impl;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.Center;
import com.clearfit.model.enums.manager.CenterManager;
import com.clearfit.model.enums.model.Slot;
import com.clearfit.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private final CenterManager centerManager = CenterManager.getInstance();

    @Override
    public void addWorkout(String name, String activity, Slot slot, int available) {
        Center center = centerManager.getCenters().get(name);
        center.addActivities(activity, slot, available);
    }
}
