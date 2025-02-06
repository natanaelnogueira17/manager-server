package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.Entity.Product;
import com.manager.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> save(@RequestBody Product product) {
		try {
			productService.save(product);
			return ResponseEntity.status(HttpStatus.CREATED).body("Produto Salvo com Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao Cadastrar produto");
		}

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Product>> findAll() {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Product> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.findBbyId(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Product product){
		try {
			productService.update(id, product);
			return ResponseEntity.status(HttpStatus.OK).body("Produto Atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
			// TODO: handle exception
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable Integer id){
		try {
			productService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Produto Deletado com Sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao Deletar produto");
		}
	}

}
