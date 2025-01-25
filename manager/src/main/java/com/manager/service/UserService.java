package com.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.Entity.User;
import com.manager.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAlList(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public User save (User user) {
		user.setDt_cadastro(new Date());
		return userRepository.save(user);
	}


	public User update (Integer id, User user) {
		Optional<User> userBanco = userRepository.findById(id);
		User userEdited = userBanco.get();
		userEdited.setId(id);
		userEdited.setDescription(user.getDescription());
		userEdited.setDt_alteracao(new Date());
		userEdited.setLogin(user.getLogin());
		userEdited.setPassword(user.getPassword());
		return userRepository.save(userEdited);
	}
	
	
	public void delete (Integer id) {

			Optional<User> user = userRepository.findById(id);
			User userNew = user.get();
			userRepository.deleteById(userNew.getId());
	
	}
	
	
	
}
