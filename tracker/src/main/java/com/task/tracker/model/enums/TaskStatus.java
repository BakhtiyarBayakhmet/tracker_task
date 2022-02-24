package com.task.tracker.model.enums;

public enum TaskStatus {
    ToDo("TO DO"),
    InProgress("In Progress"),
    Done("Done");

    private final String value;

    private TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
