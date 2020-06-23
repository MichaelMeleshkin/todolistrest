package com.todolist.service;

import com.todolist.dto.UserLoginDto;
import com.todolist.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	public String signin(UserLoginDto userLoginDto);

	public String signup(User user);

	public User currentUser(HttpServletRequest req);
	
}
