package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
