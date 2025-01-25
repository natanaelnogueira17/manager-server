package com.manager.controller;

import java.util.ArrayList;
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

import com.manager.Entity.Client;
import com.manager.Entity.Client;
import com.manager.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save (@RequestBody Client client) {
		try {
			
			clientService.save(client);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return  ResponseEntity.badRequest().build();
	}
		
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
		List<Client> lista =  new ArrayList<>();
		lista = clientService.findAlList();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }
        return ResponseEntity.ok(lista); // HTTP 200 OK com a lista de usuários
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Client>>  findById(@PathVariable Integer id) {
		Optional<Client> Client = clientService.findById(id);
		if(Client!=null) {
			return  ResponseEntity.ok().body(Client);			
		}else {
			return null;
		}
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Client client) {
		 try {
			clientService.update(id,client);
			 return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();	
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable Integer id) {
		try {
			clientService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
