package com.appsdeveloperblog.ws.api.PhotoMVCWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PhotoMvcWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoMvcWebApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
