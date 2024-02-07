package com.estivman.secondproject.second_project.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageController {
    
	@GetMapping("/")
	public String index() {
		return "<h1>Into the motherland</h1>";
	}

}