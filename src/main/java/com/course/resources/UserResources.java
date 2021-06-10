package com.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entites.User;

@RestController
@RequestMapping (value = "/users")
public class UserResources {

	@GetMapping
	public ResponseEntity <User> findAll() {
		User u = new User(1L, "juninho", "j@gmail.com", "12345", "123456");
		
		return ResponseEntity.ok().body(u);
	}
	
}
