package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entites.OrderItem;
import com.course.entites.User;
import com.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

	
}
