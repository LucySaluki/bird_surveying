package com.codeclan.example.bird_surveying.models;

public enum PrecipitationType {
    NONE("NO"),
    LIGHT_INTERMITTENT("LI"),
    LIGHT_PERSISTENT("LP"),
    HEAVY_INTERMITTENT("HI"),
    HEAVY_PERSISTENT("HP");

    private final String code;

    PrecipitationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

