package com.clearfit.model.enums.manager;

import com.clearfit.model.enums.Center;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CenterManager {
    private static final CenterManager centerManager = new CenterManager();

    private CenterManager() {
    }

    public static CenterManager getInstance() {
        return centerManager;
    }

    Map<String, Center> centers = new HashMap<>();

    public Map<String, Center> getCenters() {
        return centers;
    }

    public Optional<Center> getCenter(String center) {
        return Optional.of(centers.get(center));
    }
}
