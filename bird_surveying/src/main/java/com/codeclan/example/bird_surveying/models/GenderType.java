package com.codeclan.example.bird_surveying.models;

public enum GenderType {
    FEMALE("F"),
    MALE("M"),
    UNKNOWN("UN");

    private final String code;

    GenderType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
