package com.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.course.entites.User;
import com.course.service.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResources {

	@Autowired
	UserService service;

	
	@GetMapping
	public ResponseEntity <List<User>> findAll() {
		List<User> u = service.findAll();
		
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		service.insert(obj);
		//return ResponseEntity.ok().body(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Analisar o uso do Location 
		return ResponseEntity.created(uri).body(obj);
		//return ResponseEntity.status(HttpStatus.CREATED).body(obj); // PQ NÃO USAR ISSO
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){           //Void pq a resposta da requisição não retorna nenhum corpo. 
		service.delete(id);
		return ResponseEntity.noContent().build();        // Retornar um ResponseEntity vazio 
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity <User> update(@RequestBody User obj, @PathVariable Long id){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
