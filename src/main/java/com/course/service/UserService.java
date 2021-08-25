package com.course.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.course.entites.User;
import com.course.repositories.UserRepository;
import com.course.service.exceptions.DataBaseException;
import com.course.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public List <User> findAll() {
		
		return repository.findAll();
	}
	
	public User findById(Long id){
		
		Optional<User> obj= repository.findById(id);
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		  
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException d) {
			throw new DataBaseException(id);
		}
		
		
	}
	
	public User update(Long id, User u) {
		try {
			User obj = repository.getById(id);
			updateData(obj, u);
			return repository.save(obj);
		} catch (EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}

	}
	
	public User updateData(User u1, User u2) {
		u1.setName(u2.getName());
		u1.setEmail(u2.getEmail());
		u1.setPhone(u2.getPhone());
		return u1;
	}
	
}
