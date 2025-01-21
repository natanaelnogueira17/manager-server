package com.manager.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.Adress;

public interface AdressRepository extends JpaRepository<Adress, Integer>{
	


}
