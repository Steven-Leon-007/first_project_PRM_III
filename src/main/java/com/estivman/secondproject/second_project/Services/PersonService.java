package com.estivman.secondproject.second_project.Services;

import com.estivman.secondproject.second_project.Model.Person;

public class PersonService {
    private Person person = new Person();

    public Person generatePerson() {
        
        person.setName("Juan");
        person.setLastName("Sies");
        person.setWeight(57);
        return person;
    }
}
