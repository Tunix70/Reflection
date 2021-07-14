package com.syncretis.model;

import com.syncretis.annotation.FieldName;

public class Person {
    @FieldName(name = "Nickname")
    private String name;
    @FieldName(name = "Phone Number")
    private Long phoneNumber;

    public Person() {
    }

    public Person(String name, Long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
