package com.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.Adress;
import com.manager.repository.AdressRepository;

@Service
public class AdressService {
	@Autowired
	private AdressRepository adressRepository;
	
	
	public List<Adress> findAll() {
		return adressRepository.findAll();
	}
	
	public void save (List<Adress> adressList) {
		for (Adress adress : adressList) {
			adress.setDt_cadastro(new Date());
			adressRepository.save(adress);
			
		}
	}
	
	public void update(List<Adress> adressList, Integer id) {
		List<Integer> ids = adressRepository.findByIdAdress(id);
		for (Adress adress : adressList) {	
			for (Integer idAdress : ids) {				
			Optional<Adress> adressBanco = adressRepository.findById(idAdress);
			Adress adressUpdate = adressBanco.get();
			//adressUpdate.setId(adress.getId());
			adressUpdate.setStreet(adress.getStreet());
			adressUpdate.setNumber(adress.getNumber());
			adressUpdate.setComplement(adress.getComplement());
			adressUpdate.setCity(adress.getCity());
			adressUpdate.setState(adress.getState());
			adressUpdate.setDt_alteracao(new Date());
			adressRepository.save(adressUpdate);
			}
		 }
		
	}
	
	
	public void delete(Integer id) {
		adressRepository.deleteById(id);
	}
	
}
