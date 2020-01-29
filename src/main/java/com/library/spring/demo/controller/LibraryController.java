package com.library.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.spring.demo.beans.Library;
import com.library.spring.demo.dao.LibraryRepository;

@RestController
public class LibraryController {
	
	@Autowired
	LibraryRepository repo;
	
	@GetMapping(path="/library")
	public List<Library> getBooks(){
		return repo.findAll();
	}
	
	@RequestMapping("/")
	public String Hw()
	{
		return "Welcome to Library Management";
	}
	
	@GetMapping(path="/library/{id}")
	public Library getBook(@PathVariable("id") String id) {
		Library l = repo.findById(id).orElse(new Library ("nill","nill"));
		return l;
	}
	
	@PostMapping(path="/library",consumes= {"application/json"})
	public Library addBook(@RequestBody Library l) {
		repo.save(l);
		return l;
	}
	
	/*@PostMapping(path="/getBookName",consumes= {"application/json"})
	public List<Library> getBookByName (@RequestBody Library l) {
		System.out.println("BookByname Called");
		return repo.findByAuthorName(l.getAuthorName());
	}*/
	
	@GetMapping(path="/getBook/{authorName}")
	public List<Library> getBookByField(@PathVariable("authorName") String auth)
	{
		return repo.findByAuthorName(auth);
	}
	
}
