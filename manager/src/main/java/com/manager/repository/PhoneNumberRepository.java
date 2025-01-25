package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.Entity.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer>{
	
	@Query(value = "SELECT p.id FROM tb_client c " +
            "JOIN tb_phone_number p ON c.id = p.client_id " +
            "WHERE p.client_id = :id", nativeQuery = true)
	public List<Integer> findByIdPhone(@Param("id") Integer id);

}
