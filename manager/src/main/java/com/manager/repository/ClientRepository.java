package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
