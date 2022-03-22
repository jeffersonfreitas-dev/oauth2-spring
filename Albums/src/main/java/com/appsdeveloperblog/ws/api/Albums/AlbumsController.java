package com.appsdeveloperblog.ws.api.Albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

	@GetMapping
	public List<Albums> getAll(){
		Albums a1 = new Albums("123", "ALBUM EXEMPLO 01");
		Albums a2 = new Albums("321", "ALBUM EXEMPLO 02");
		Albums a3 = new Albums("213", "ALBUM EXEMPLO 03");
		List<Albums> result = new ArrayList<>();
		result.add(a1);
		result.add(a2);
		result.add(a3);
		return result;
	}
}
