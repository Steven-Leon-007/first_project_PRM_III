package com.estivman.secondproject.second_project.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estivman.secondproject.Services.PersonService;
import com.estivman.secondproject.second_project.Model.Person;

@RestController
@RequestMapping("/")
public class MessageController {

    PersonService person;
    
	@GetMapping("/")
	public Person index() {
        this.person = new PersonService();
        return person.generatePerson();
	}

}