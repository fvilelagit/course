package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entites.Category;
import com.course.entites.User;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}
