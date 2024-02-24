package com.estivman.secondproject.second_project.Controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estivman.secondproject.DynamicMemory.UptcList;
import com.estivman.secondproject.second_project.Model.Person;

@RestController
@RequestMapping("/")
public class MessageController {

    @GetMapping("/")
    public <T> String index() {

        Person persona1 = new Person("pedro", "laverde", 45);
        Person persona2 = new Person("Diegoschi", "kalsjfkl", 80);
        Person persona3 = new Person("Juan", "Ci", 74);
        Person persona4 = new Person("Juan", "Ci", 74);
        Person persona5 = new Person("Nuevo", "jKKADJSJ", 74);

        UptcList<Person> test = new UptcList<Person>(); // Library
        test.add(persona1);
        test.add(persona2);
        test.add(persona3);
        test.add(persona4);

        // test.show();
        // test.clear();
        // test.show();

        UptcList<String> lista = new UptcList<>();
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("!");

        // Obtenemos un Iterator para la lista
        Iterator<String> iterator = lista.iterator();

        // Iteramos sobre la lista usando el Iterator
        while (iterator.hasNext()) {
            String elemento = iterator.next();
            System.out.println(elemento);
        }

        String output = "<style>body{background-color: #323232;} h1{color: #fff;}</style><h1>Into the motherland the german army march </h1><br><img src=\"https://cdn.7tv.app/emote/619ceb1beecae7a725bc91a5/4x.webp\" style=\"width: 200px;\"/>";

        return output;
    }

    @PostMapping("/add")
    public String postMethodName(@RequestBody String entity) {
        // entity is the object that will be saved
        return entity;
    }

}