package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
