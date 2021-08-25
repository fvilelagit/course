package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entites.Product;
import com.course.service.ProductService;

@RestController
@RequestMapping (value = "/products")
public class ProductResources {

	@Autowired
	ProductService service;

	
	@GetMapping
	public ResponseEntity <List<Product>> findAll() {
		List<Product> u = service.findAll();
		
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product u = service.findById(id);
		return ResponseEntity.ok().body(u);
		
	}
}
