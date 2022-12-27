package com.tt.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tt.demo.dto.ResponseDto;
import com.tt.demo.model.Users;
import com.tt.demo.service.Userservice;

@RestController
public class UserApicontroller {
	@Autowired
	private Userservice userService;
//	@Autowired
//	private HttpSession session;
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody Users user) {
//		user.setRoles(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody Users user){
		userService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);

	}
}
