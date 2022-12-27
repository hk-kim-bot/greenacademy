package com.tt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.demo.model.boards;

public interface BoardRepository extends JpaRepository<boards,Integer>{

	List<boards> findByContentContaining(String keyword);

	

	

}
