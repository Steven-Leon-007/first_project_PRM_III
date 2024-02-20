package com.estivman.secondproject.second_project.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estivman.secondproject.DynamicMemory.UptcList;
import com.estivman.secondproject.second_project.Model.Person;
import com.estivman.secondproject.second_project.Services.PersonService;

@RestController
@RequestMapping("/")
public class MessageController {

    PersonService person;

    @GetMapping("/")
    public <T> Person index() {
        UptcList<String> list = new UptcList<>();
        list.add("cero");
        list.add("uno");
        list.add("dos");
        list.add("tres");
        //list.show();
        // System.out.println(list.get(1));
        // System.out.println(list.size());

        // list.add(0, "ultimo");

        // list.show();

        // System.out.println(list.findNode(2).getInfo() + "asjfk");

        Person persona1 = new Person("pedro", "laverde", 45);
        Person persona2 = new Person("Diegoschi", "kalsjfkl", 80);
        Person persona3 = new Person("Juan", "Ci", 74);
        Person persona4 = new Person("Juan", "Ci", 74);

        List<Person> test = new UptcList<Person>();
        test.add(persona1);
        test.add(persona2);
        test.add(persona3);
        test.add(persona3);

        System.out.println(test.lastIndexOf(persona4));

        this.person = new PersonService();
        return person.generatePerson();
    }

}