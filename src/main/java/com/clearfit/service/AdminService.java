package com.clearfit.service;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.manager.CenterManager;
import com.clearfit.model.enums.model.Slot;

public interface AdminService {

    void addWorkout(String name, String activity, Slot slot, int available);



}
