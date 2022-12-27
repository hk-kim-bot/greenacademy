package com.tt.demo.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tt.demo.model.Users;
import com.tt.demo.repository.Userrepository;

@Service
public class PrincipalDetailService implements UserDetailsService{
	@Autowired
	private Userrepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당사용자를 찾을 수 없습니다. :"+username);
				});
		 		return new PrincipalDetail(principal);
				
	}
}
