package com.se.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
