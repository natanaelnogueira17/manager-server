package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
