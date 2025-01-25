package com.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.Client;
import com.manager.Entity.PhoneNumber;
import com.manager.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PhoneNumberService numberService;
	@Autowired
	private AdressService adressService;
	
	public List<Client> findAlList(){
		return clientRepository.findAll();
	}
	
	public Optional<Client> findById(Integer id) {
		return clientRepository.findById(id);
	}
	
	public void save (Client client) {
		client.setDt_cadastro(new Date());
		numberService.save(client.getPhoneNumbers());
		adressService.save(client.getAdress());		
		clientRepository.save(client);
	}


	public void update (Integer id, Client client) {
		Optional<Client> clientBanco = clientRepository.findById(id);
		Client newClientData = clientBanco.get();
		newClientData.setId(id);
		newClientData.setDt_alteracao(new Date());
		newClientData.setDescricao(client.getDescricao());
		newClientData.setCpf(client.getCpf());
		newClientData.setEmail(client.getEmail());
		newClientData.setSize(client.getSize());
		numberService.update(client.getPhoneNumbers(), id);
		adressService.update(client.getAdress(),id);		   
		clientRepository.save(newClientData);
		
	}
	
	
	public void delete (Integer id) {
		clientRepository.deleteById(id);
	
	}

	
	
	
}
