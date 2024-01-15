package com.clearfit.service;

import com.clearfit.model.enums.model.Slot;
import com.clearfit.model.enums.response.WorkoutAvailabilityResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UUID register(String name);

    List<WorkoutAvailabilityResponse> viewWorkoutAvailability(String activityName);

    boolean bookASession(String name, String center, String activity, Slot slot);

    boolean cancelASession(String name, String centerName, String activityName, Slot requestedSlot);
}
