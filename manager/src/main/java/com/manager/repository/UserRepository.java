package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
