package com.springreactproject.ws.user;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	@CrossOrigin
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userService.save(user);
		}
	

}
