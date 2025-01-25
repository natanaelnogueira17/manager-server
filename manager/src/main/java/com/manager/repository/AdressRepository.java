package com.manager.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Adress;
@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer>{
	


}
