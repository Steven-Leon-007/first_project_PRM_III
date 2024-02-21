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
    public <T> String index() {

        Person persona1 = new Person("pedro", "laverde", 45);
        Person persona2 = new Person("Diegoschi", "kalsjfkl", 80);
        Person persona3 = new Person("Juan", "Ci", 74);
        Person persona4 = new Person("Juan", "Ci", 74);

        List<Person> test = new UptcList<Person>();
        test.add(persona1);
        test.add(persona2);
        test.add(persona3);
        test.add(persona3);

        System.out.println(test.lastIndexOf(persona3));
        String output = "<style>body{background-color: #323232;} h1{color: #fff;}</style><h1>Into the motherland the german army march </h1><br><img src=\"https://cdn.7tv.app/emote/619ceb1beecae7a725bc91a5/4x.webp\" style=\"width: 200px;\"/>";

        return output;
    }

}