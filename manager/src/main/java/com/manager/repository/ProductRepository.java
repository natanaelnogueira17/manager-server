package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
