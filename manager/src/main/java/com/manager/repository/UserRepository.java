package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
