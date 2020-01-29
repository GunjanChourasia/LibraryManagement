package com.library.spring.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.spring.demo.beans.Library;

public interface LibraryRepository extends MongoRepository<Library, String>{
	List<Library>findByAuthorName(String authorName);
}
