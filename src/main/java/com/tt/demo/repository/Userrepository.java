package com.tt.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.demo.model.Users;

public interface Userrepository extends JpaRepository<Users,Integer>{
//		Users findByUsernameAndPassword(String username,String password);
	Optional<Users> findByUsername(String username);
	
}
