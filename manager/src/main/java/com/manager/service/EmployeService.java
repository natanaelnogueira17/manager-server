package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.Employe;
import com.manager.repository.EmployeRepository;

@Service
public class EmployeService {
	
	@Autowired
	private EmployeRepository employeRepository;
	
	public List<Employe> findAll(){
		return employeRepository.findAll(); 
	}
	
	public Optional<Employe> findById(Integer id) {
		return employeRepository.findById(id);
		
	}
}
