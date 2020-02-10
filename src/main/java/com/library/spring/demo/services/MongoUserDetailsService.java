package com.library.spring.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.library.spring.demo.beans.Users;
import com.library.spring.demo.dao.UserRepository;

@Component
public class MongoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users user = repository.findByUsername(username);
		System.out.println("auth started");
		System.out.println(user);
		if (user==null) {
			System.out.println("galat user");
			throw new UsernameNotFoundException("User not found");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		return new User(user.getUsername(), user.getPassword(),authorities);
	}
}