package com.library.spring.demo.beans;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
	@Id
	public ObjectId _id;
	
	public String username;
	public String password;
	
	public Users() {}
	
	public Users(ObjectId _id, String username, String password) {
		this._id = _id;
		this.username = username;
		this.password = password;
		System.out.println(username+password);
	}

	public void set_id(ObjectId _id) { this._id = _id; }

	public String get_id() { return this._id.toHexString(); }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
