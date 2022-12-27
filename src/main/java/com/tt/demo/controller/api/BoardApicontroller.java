package com.tt.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tt.demo.config.auth.PrincipalDetail;
import com.tt.demo.dto.ResponseDto;
import com.tt.demo.model.boards;
import com.tt.demo.service.BoardService;

@RestController
public class BoardApicontroller {
	@Autowired
	private BoardService boardservice;
	
	
	
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody boards board,@AuthenticationPrincipal PrincipalDetail principal){
		boardservice.글쓰기(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
		
	}
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deletebyid(@PathVariable int id){
		boardservice.글삭제하기(id);
		return new  ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id,@RequestBody boards board){
		boardservice.글수정하기(id,board);
		return new  ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
