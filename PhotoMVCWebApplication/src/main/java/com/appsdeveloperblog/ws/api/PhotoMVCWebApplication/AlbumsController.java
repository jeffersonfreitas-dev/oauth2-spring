package com.appsdeveloperblog.ws.api.PhotoMVCWebApplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumsController {

	@GetMapping
	public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
		
		System.out.println("Principal => "+ principal);
		OidcIdToken token = principal.getIdToken();
		
		String tokenValue = token.getTokenValue();
		System.out.println("Token => " + tokenValue);
		
		Albums a1 = new Albums.Builder("001", "Album 01", "http://localhost:8099/albums/1").build();
		Albums a2 = new Albums.Builder("002", "Album 02", "http://localhost:8099/albums/2").build();
		List<Albums> list = Arrays.asList(a1, a2);
		model.addAttribute("albums", list);
		return "albums";
	}
}
