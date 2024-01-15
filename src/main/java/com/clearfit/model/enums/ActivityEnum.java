package com.clearfit.model.enums;

public enum ActivityEnum {

    WEIGHTS("weights"), CARDIO("cardio"), YOGA("yoga"), SWIMMING("swimming");

    final String name;

    ActivityEnum(String name) {
        this.name = name;
    }
}
