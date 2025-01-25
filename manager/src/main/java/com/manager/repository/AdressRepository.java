package com.manager.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Adress;
@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer>{

	@Query(value = "SELECT a.id FROM tb_client c " +
            		"JOIN tb_adress a ON c.id = a.client_id " +
            		"WHERE a.client_id = :id", nativeQuery = true)
	List<Integer> findByIdAdress(@Param("id") Integer id);
	


}
