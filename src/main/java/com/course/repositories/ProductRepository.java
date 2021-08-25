package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
