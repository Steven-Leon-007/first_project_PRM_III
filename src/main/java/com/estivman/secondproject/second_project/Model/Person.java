package com.estivman.secondproject.second_project.Model;

import lombok.Getter;
import lombok.Setter;

public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name) > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", lastName=" + lastName + ", weight=" + weight + "]";
    }

    

}
