package com.appsdeveloperblog.ws.api.ResourceServer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@GetMapping("/status/check")
	public String status() {
		return "It's working";
	}
	
	
	@Secured("ROLE_developer")
	@DeleteMapping(path = "/{id}")
	public String deleteUser (@PathVariable String id) {
		return "Deleted user with id " + id;
	}

}
