package com.library.spring.demo.testcontroller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.spring.demo.beans.Library;
import com.library.spring.demo.controller.LibraryController;
import com.library.spring.demo.dao.LibraryRepository;

@RunWith(SpringRunner.class)
public class LibraryTestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LibraryRepository repository;
	
	@Autowired
	private LibraryController libraryController;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void getBooksTest(){
		when(repository.findAll()).thenReturn(Stream.of(new Library("HP","J.K.",4), new Library("Inferno","Dan Brown",2)).collect(Collectors.toList()));
		assertEquals(2, libraryController.getBooks().size());
	}
	
	@Test
	public void getBookByField() {
		String author = "J.K.";
		when(repository.findByBookName(author)).thenReturn(Stream.of(new Library("HP","J.K.",4)).collect(Collectors.toList()));
		assertEquals(1,libraryController.getBookByField(author).size());
	}
	
	
	
}
