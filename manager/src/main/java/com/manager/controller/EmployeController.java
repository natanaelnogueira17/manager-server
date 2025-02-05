package com.manager.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manager.Entity.Employe;
import com.manager.service.EmployeService;

@RestController
@RequestMapping(value = "/employe")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Employe>> findAll(){
		List<Employe> lista = employeService.findAll();
		if(!lista.isEmpty()) {
		return ResponseEntity.ok(lista);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
		}
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Employe>> findById(@PathVariable Integer id){
		Optional<Employe> employe = employeService.findById(id);
		if(employe != null) {
			return ResponseEntity.ok(employe);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String>  save (@RequestBody Employe employe) {
		try {
			employeService.save(employe);
		return ResponseEntity.status(HttpStatus.CREATED).body("Salvo com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha em Salvar");
		}	
	}
	
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Employe employe){
		
		try {
			employeService.update(id, employe);
			return ResponseEntity.status(HttpStatus.OK).body("Atualizado com Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha em Atualizar");
		}
	}
	@DeleteMapping(value ="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		try {
			 employeService.delete(id);
			 return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao Deletar");
		}
	}
	
	
	
	
	
	
	
	
	
	

}
