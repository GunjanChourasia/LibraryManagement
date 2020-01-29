package com.library.spring.demo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="library")
public class Library {

	String bookName;
	String authorName;
	@Id
	String id;
	
	public Library() {
		super();
	}

	public Library(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "Library [bookName=" + bookName + ", authorName=" + authorName + ", id=" + id + "]";
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
}
