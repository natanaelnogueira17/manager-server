package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
