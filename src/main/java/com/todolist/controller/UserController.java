package com.todolist.controller;

import com.todolist.dto.TokenDto;
import com.todolist.dto.UserDto;
import com.todolist.dto.UserInfoDto;
import com.todolist.dto.UserLoginDto;
import com.todolist.entity.Role;
import com.todolist.entity.User;
import com.todolist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signin")
	public TokenDto signin(@RequestBody UserLoginDto userLoginDto) {
		TokenDto dto = new TokenDto();
		dto.setToken(userService.signin(userLoginDto));
		return dto;
	}

	@PostMapping("/signup")
	public TokenDto signup(@RequestBody UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		TokenDto dto = new TokenDto();
		dto.setToken(userService.signup(user));
		return dto;
	}

	@GetMapping("/me")
	public UserInfoDto getCurrentUser(HttpServletRequest req) {
		return modelMapper.map(userService.currentUser(req), UserInfoDto.class);
	}
}










