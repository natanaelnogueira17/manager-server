package com.manager.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.Entity.User;
import com.manager.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save (@RequestBody User user) {
		try {
		 userService.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return  ResponseEntity.badRequest().build();
	}
		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
		List<User> lista =  new ArrayList<>();
		lista = userService.findAlList();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }
        return ResponseEntity.ok(lista); // HTTP 200 OK com a lista de usuários
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>>  findById(@PathVariable Integer id) {
		Optional<User> user = userService.findById(id);
		if(user!=null) {
			return  ResponseEntity.ok().body(user);			
		}else {
			return null;
		}
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User userEdit) {
		 try {
			 userService.update(id, userEdit);
			return  (ResponseEntity<?>) ResponseEntity.ok();
		} catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.notFound().build();	
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id) {
		try {
			userService.delete(id);
			return (ResponseEntity<?>)ResponseEntity.ok();
		} catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.notFound().build();
		}
	
	}
	
	
}
