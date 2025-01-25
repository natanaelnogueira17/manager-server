package com.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.PhoneNumber;
import com.manager.repository.PhoneNumberRepository;

@Service
public class PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;
	
	public List<PhoneNumber> findAll(){
		
		return phoneNumberRepository.findAll(); 
	}
	
	public void save (List<PhoneNumber> phoneNumbers) {
	    for (PhoneNumber phoneNumber : phoneNumbers) {
	    	phoneNumber.setDt_cadastro(new Date());
	    	phoneNumberRepository.save(phoneNumber);		
		}
	}
	
	public void update(List<PhoneNumber> phoneNumbers, Integer id) {
		List<Integer> ids = phoneNumberRepository.findByIdPhone(id);
		for(PhoneNumber phoneNumber : phoneNumbers) {
			for(Integer idPhone: ids) {
			Optional<PhoneNumber> result = phoneNumberRepository.findById(idPhone);
			PhoneNumber phonenumberbanco = result.get();
	//		phonenumberbanco.setId(idPhone);
			phonenumberbanco.setMobile(phoneNumber.getMobile());
			phonenumberbanco.setFix(phoneNumber.getFix());
			phonenumberbanco.setDt_alteracao(new Date());
			phoneNumberRepository.save(phonenumberbanco);
		}
		}
	}
	
	public void delete (Integer id) {
		phoneNumberRepository.deleteById(id);
	}
	
}
