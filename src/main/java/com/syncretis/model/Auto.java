package com.syncretis.model;

public class Auto {
    private String color;
    private String id;

    public Auto() {
    }

    public Auto(String color, String id) {
        this.color = color;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "color='" + color + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
