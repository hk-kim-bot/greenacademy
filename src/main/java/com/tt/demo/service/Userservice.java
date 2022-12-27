package com.tt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.demo.model.RoleType;
import com.tt.demo.model.Users;
import com.tt.demo.repository.Userrepository;

@Service
public class Userservice {
	@Autowired
	private Userrepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;	
	@Transactional
	public void 회원가입(Users user) {
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRoles(RoleType.USER);
		userRepository.save(user);
	}
//	@Transactional(readOnly=true)
//	public Users 로그인(Users user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	@Transactional
	public void 회원수정(Users user) {
		Users userrefer =userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		userrefer.setPassword(encPassword);
		userrefer.setEmail(user.getEmail());
	}
}
