package com.library.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Library lib = repo.findById(id).orElse(new Library ("nill","nill",0));
		return lib;
	}
	
	@PostMapping(path="/library",consumes= {"application/json"})
	public Library addBook(@RequestBody Library lib) {
		repo.save(lib);
		return lib;
	}
	
	@GetMapping(path="/getBook/{bookName}")
	public List<Library> getBookByField(@PathVariable("bookName") String book)
	{
		return repo.findByBookName(book);
	}
	
	@DeleteMapping(path="/bookDelete/{id}")
	public String deleteBook(@PathVariable("id") String id) {
		repo.deleteById(id);
		return id+"Deleted Successfuly";
	}
	
	@PutMapping(path="/bookIssue/{bookName}", consumes= {"application/json"})
	public List<Library> issueBook(@PathVariable("bookName") String book) {
		List<Library> lib = repo.findByBookName(book);
		int count = lib.get(0).getBookCount();
		if (count>0) {
			lib.get(0).setBookCount(count-1);
		}
		return lib;
	}
	
	
	
}
