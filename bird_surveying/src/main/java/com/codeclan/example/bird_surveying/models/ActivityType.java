package com.codeclan.example.bird_surveying.models;

public enum ActivityType {
    FLYING("F"),
    SUMMERING("U"),
    SUITABLE_HABITAT("H"),
    SINGING("S"),
    PAIR("P"),
    DISPLAY("D"),
    TERRITORY("T"),
    AGITATED("A"),
    VISIT_NEST("N"),
    BUILD_NEST("B"),
    INCUBATING("I"),
    DISTRACTION("DD"),
    USED_NEST("UN"),
    NEST_EGGS("NE"),
    FOOD_FECAL("FF"),
    FLEDGED("FL"),
    OCCUPIED_NEST("ON"),
    NEST_YOUNG("NY");

    private final String code;

    ActivityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

