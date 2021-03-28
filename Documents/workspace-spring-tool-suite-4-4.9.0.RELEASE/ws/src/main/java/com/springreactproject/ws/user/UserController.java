package com.springreactproject.ws.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springreactproject.ws.error.ApiError;
import com.springreactproject.ws.shared.GenericResponse;

import antlr.collections.List;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		ApiError error = new ApiError(400, "Validation error", "/user");
		Map<String, String> validationErrors= new HashMap<>();
		
		String username = user.getUsername();
		String displayName = user.getUsername();

		if(username== null || username.isEmpty()) {
			
			validationErrors.put("username", "username can not be null");
		}
		
		if(displayName== null || displayName.isEmpty()) {
			
			validationErrors.put("displayName", "displayName can not be null");
			
		}
		
		if (validationErrors.size()>0) {
			error.setValidationErrors(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
		
		userService.save(user);
		return ResponseEntity.ok(new GenericResponse("user created"));
		}
	

}
