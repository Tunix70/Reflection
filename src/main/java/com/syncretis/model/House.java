package com.syncretis.model;

import com.syncretis.annotation.FieldName;

public class House {
    @FieldName(name = "House Number")
    private int id;
    private String location;

    public House() {
    }

    public House(int id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
