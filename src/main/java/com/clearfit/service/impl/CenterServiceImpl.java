package com.clearfit.service.impl;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.Center;
import com.clearfit.model.enums.manager.CenterManager;
import com.clearfit.model.enums.model.Slot;
import com.clearfit.service.CenterService;

import java.util.List;
import java.util.Map;

public class CenterServiceImpl implements CenterService {

    private final CenterManager centerManager = CenterManager.getInstance();
    Map<String, Center> centers = centerManager.getCenters();

    @Override
    public boolean addCenter(String name) {
        if (!centers.containsKey(name)) {
            Center center = new Center(name);
            centers.put(name, center);
            return true;
        }
        return false;

    }

    @Override
    public void addCenterActivities(String name, List<Activity> activities) {
        if (centers.containsKey(name)) {
            centers.put(name, new Center(name));
        }
        Center center = centers.get(name);
        activities.forEach(center::addActivities);
        centers.put(name, center);
    }

    @Override
    public void addCenterTimings(String name, List<Slot> slots) {
        if (centers.containsKey(name)) {
            centers.put(name, new Center(name));
        }
        centers.get(name).setCenterTime(slots);

    }
}
