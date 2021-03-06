package com.appsdeveloperblog.ws.api.PhotoMVCWebApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/albums")
public class AlbumsController {
	
	@Autowired
	OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	WebClient webClient;

	@GetMapping
	public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
		
		
		//EXEMPLO RESTTEMPLATE
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//		
//		OAuth2AuthorizedClient oauthClient =  oAuth2AuthorizedClientService
//				.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());
//		String jwtToken = oauthClient.getAccessToken().getTokenValue();
//		System.out.println("jwtAcccessToken = " + jwtToken);
//		
//		System.out.println("Principal => "+ principal);
//		OidcIdToken token = principal.getIdToken();
//		
//		String tokenValue = token.getTokenValue();
//		System.out.println("Token => " + tokenValue);
//		
//		String url = "http://localhost:8082/albums";
//		HttpHeaders header = new HttpHeaders();
//		header.add("Authorization", "Bearer " + jwtToken);
//		
//		HttpEntity<HttpHeaders> entity = new HttpEntity<>(header); 
//		
//		ResponseEntity<List<Albums>> result = restTemplate.exchange(url, HttpMethod.GET, entity, 
//				new ParameterizedTypeReference<List<Albums>>(){});
//		List<Albums> list = result.getBody();
//		
//		model.addAttribute("albums", list);
//		return "albums";
		
		String url = "http://localhost:8082/albums";
		List<Albums> list = webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Albums>>() {})
				.block();
		model.addAttribute("albums", list);
		return "albums";
		
	}
}
