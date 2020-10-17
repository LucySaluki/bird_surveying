package com.codeclan.example.bird_surveying.models;

public enum AgeType {
    EGG ("EG"),
    IMMATURE("IM"),
    JUVENILE("JU"),
    FIRST_YEAR("1Y"),
    SECOND_YEAR("2Y"),
    ADULT("AD"),
    UNKNOWN("UN");

    private final String code;

    AgeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
