package com.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.manager.Entity.Client;
import com.manager.Entity.Client;
import com.manager.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Client client) {
		try {
			
			clientService.save(client);
			 return ResponseEntity.status(HttpStatus.CREATED).body("Cliente Salvo com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao salvar Cliente");
	}
		
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
		List<Client> lista =  new ArrayList<>();
		lista = clientService.findAlList();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);// HTTP 204 No Content
        }
        return ResponseEntity.ok(lista); // HTTP 200 OK com a lista de usuários
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Client>>  findById(@PathVariable Integer id) {
		Optional<Client> Client = clientService.findById(id);
		if(Client!=null) {
			return  ResponseEntity.ok().body(Client);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Client client) {
		 try {
			clientService.update(id,client);
			 return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao atualizar cliente");
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  delete (@PathVariable Integer id) {
		try {
			clientService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao Deletar");
		}
	}
	
	
}
