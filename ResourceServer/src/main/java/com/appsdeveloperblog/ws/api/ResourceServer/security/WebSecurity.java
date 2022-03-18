package com.appsdeveloperblog.ws.api.ResourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	//Registrar o KeycloakConverter no SpringSecurity utilizando a classe JwtAuthenticationConverter e adicionando no método configure
	JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
	jwtAuthenticationConverter
//	jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/users/status/check")
//				.hasAuthority("SCOPE_profile")
//				.hasAnyRole("developer", "user")
				.hasRole("developer")
			.anyRequest().authenticated()
			.and()
			.oauth2ResourceServer()
			.jwt();
	}

}
