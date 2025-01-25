package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.PhoneNumber;
@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer>{

}
