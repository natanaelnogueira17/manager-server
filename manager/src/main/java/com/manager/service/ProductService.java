package com.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.Product;
import com.manager.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public void save(Product product) {
		product.setDt_cadastro(new Date());
		productRepository.save(product);
	}
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	
	public Product findBbyId(Integer id){
		
		Optional<Product>result  = productRepository.findById(id);
		Product product = result.get();
		return product;
		
	}
	
	public void update(Integer id, Product product) {
		Optional<Product>result  = productRepository.findById(id);
		Product productBanco = result.get();
		product.setDt_alteracao(new Date());
		product.setDt_cadastro(productBanco.getDt_cadastro());		
		productRepository.save(product);
	}
	
	public void delete (Integer id) {
		Product product = findBbyId(id);
		product.setDt_alteracao(new Date());
		productRepository.delete(product);
	}
	
	
}
