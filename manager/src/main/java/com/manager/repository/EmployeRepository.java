package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
