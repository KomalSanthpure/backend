package com.example.demo.repo;


import com.example.demo.model.User; // Example package name

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>   {
	
	

	
	    // Additional custom queries can be added here

	    Optional<User> findByName(String name);

	    Optional<User> findByCity(String city);
	}



