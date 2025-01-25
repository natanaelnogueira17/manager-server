package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
