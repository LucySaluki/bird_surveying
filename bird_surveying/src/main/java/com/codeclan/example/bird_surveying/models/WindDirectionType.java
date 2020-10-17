package com.codeclan.example.bird_surveying.models;

public enum WindDirectionType {
    NORTH("N"),
    NORTH_EAST("NE"),
    EAST("E"),
    SOUTH_EAST("SE"),
    SOUTH("S"),
    SOUTH_WEST("SW"),
    WEST("W"),
    NORTH_WEST("NW");

    private final String code;

    WindDirectionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
