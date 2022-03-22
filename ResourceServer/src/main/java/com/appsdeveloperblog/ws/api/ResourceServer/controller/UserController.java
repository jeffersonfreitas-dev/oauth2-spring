package com.appsdeveloperblog.ws.api.ResourceServer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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

	
//	@PreAuthorize("hasRole('developer') or #id == #jwt.subject")
//	@DeleteMapping(path = "/sub/{id}")
//	public String deleteBySubJWT (@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
//		return "Updated user with id " + id + " and JWT subject " + jwt.getSubject();
//	}


	@PostAuthorize("#id == #jwt.subject") //Get os dados do proprio user
	@GetMapping(path = "/{id}")
	public String getUser (@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "GetUser authorizaded with id " + id;
	}

}
