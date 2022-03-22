package com.appsdeveloperblog.ws.api.Photos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@GetMapping
	public List<Photos> getAll(){
		Photos a1 = new Photos("123", "PHOTO EXEMPLO 01");
		Photos a2 = new Photos("321", "PHOTO EXEMPLO 02");
		Photos a3 = new Photos("213", "PHOTO EXEMPLO 03");
		List<Photos> result = new ArrayList<>();
		result.add(a1);
		result.add(a2);
		result.add(a3);
		return result;
	}

}
