package com.capgemini.wsb.fitnesstracker.training.internal;

/**
 * Available activity types: RUNNING, CYCLING, WALKING, SWIMMING, TENNIS
 */
public enum ActivityType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    WALKING("Walking"),
    SWIMMING("Swimming"),
    TENNIS("Tenis");

    /**
     * Display name for given activity type
     */
    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
