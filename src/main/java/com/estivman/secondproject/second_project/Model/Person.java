package com.estivman.secondproject.second_project.Model;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    private String name;
    private String lastName;
    private int weight;

    public Person() {
    }

    public Person(String name, String lastName, int weight) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
    }

}
