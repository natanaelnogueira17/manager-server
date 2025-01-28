package com.manager.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
			return ResponseEntity.notFound().build();			
		}
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Employe>> findById(@PathVariable Integer id){
		Optional<Employe> employe = employeService.findById(id);
		if(employe != null) {
			return ResponseEntity.ok(employe);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<?>  save (@RequestBody Employe employe) {
		try {
			employeService.save(employe);
		return ResponseEntity.ok(employe);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.noContent().build();
		}	
	}
	
	
	
	
	
	
	
	
	
	

}
