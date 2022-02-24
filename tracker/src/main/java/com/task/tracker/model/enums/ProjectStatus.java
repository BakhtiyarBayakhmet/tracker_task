package com.task.tracker.model.enums;

public enum ProjectStatus {
    NotStarted("Not started"),
    Active("Active"),
    Completed("Completed");

    private final String value;

    private ProjectStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
