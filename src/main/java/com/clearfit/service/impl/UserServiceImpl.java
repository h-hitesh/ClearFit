package com.clearfit.service.impl;

import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.Center;
import com.clearfit.model.enums.manager.CenterManager;
import com.clearfit.model.enums.manager.SessionManager;
import com.clearfit.model.enums.manager.UserManager;
import com.clearfit.model.enums.model.Session;
import com.clearfit.model.enums.model.Slot;
import com.clearfit.model.enums.model.User;
import com.clearfit.model.enums.response.WorkoutAvailabilityResponse;
import com.clearfit.service.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {
    private final UserManager userManager = UserManager.getInstance();
    private final CenterManager centerManager = CenterManager.getInstance();
    private final SessionManager sessionManager = SessionManager.getInstance();

    @Override
    public UUID register(String name) {
        return userManager.addUser(name);
    }

    @Override
    public List<WorkoutAvailabilityResponse> viewWorkoutAvailability(String activityName) {
        Map<String, Center> centers = centerManager.getCenters();
        List<WorkoutAvailabilityResponse> response = new ArrayList<>();
        centers.forEach((name, center) -> {
            Optional<Activity> optionalActivity = center.getActivityByName(activityName);
            if (optionalActivity.isPresent()) {
                Activity activity = optionalActivity.get();
                Slot slot = activity.getSlot();
                WorkoutAvailabilityResponse availabilityResponse = new WorkoutAvailabilityResponse(center.getName(), activity, slot);
                response.add(availabilityResponse);
            }
        });

        return response;
    }

    @Override
    public boolean bookASession(String name, String centerName, String activityName, Slot requestedSlot) {
        synchronized (this) {
            User user = userManager.getUser(name).orElseThrow();
            Center center = centerManager.getCenter(centerName).orElseThrow();
            Optional<Activity> activityOptional = center.getActivityByName(activityName);
            if (activityOptional.isPresent()) {
                Activity activity = activityOptional.get();
                Slot slot = activity.getSlot();
                if (slot.equals(requestedSlot) && activity.getAvailable() > 1) {
                    Session session = new Session(user.getUserId(), centerName, activity);
                    activity.setAvailable(activity.getAvailable() - 1);
                    sessionManager.bookSession(user, session);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean cancelASession(String name, String centerName, String activityName, Slot requestedSlot) {
        synchronized (this) {
            User user = userManager.getUser(name).orElseThrow();
            Optional<Session> sessionOptional = user.getSession(centerName, activityName, requestedSlot);
            if (sessionOptional.isPresent()) {
                Session session = sessionOptional.get();
                sessionManager.cancelSession(user, session);
                return true;
            }
        }
        return false;
    }


}
