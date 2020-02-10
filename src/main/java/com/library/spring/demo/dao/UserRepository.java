package com.library.spring.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.spring.demo.beans.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);
}
