package com.estivman.secondproject.second_project.Model;

public class Person {
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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    
}
