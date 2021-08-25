package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entites.Order;
import com.course.entites.User;
import com.course.service.OrderService;
import com.course.service.UserService;

@RestController
@RequestMapping (value = "/orders")
public class OrderResources {

	@Autowired
	OrderService service;

	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> u = service.findAll();
		
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order u = service.findById(id);
		return ResponseEntity.ok().body(u);
		
	}
}
