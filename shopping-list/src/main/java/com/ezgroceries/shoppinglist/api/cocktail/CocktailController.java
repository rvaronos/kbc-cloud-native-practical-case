package com.ezgroceries.shoppinglist.api.cocktail;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CocktailController {

	private static final Logger log = LoggerFactory.getLogger(CocktailController.class);

	private CocktailService cocktailService;

	@GetMapping(value = "/cocktails")
	public List<Cocktail> cocktails(@RequestParam String search) {
		log.info("Request cocktails list");
		return this.cocktailService.getAll(search);

	}

}
