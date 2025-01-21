package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
