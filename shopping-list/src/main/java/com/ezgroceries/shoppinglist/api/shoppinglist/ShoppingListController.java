package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShoppingListController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final ShoppingListService shoppingListService;

	@PostMapping(value = "/shopping-lists")
	public ResponseEntity<Void> create(@RequestBody ShoppingListBodyCreate body) {

		ShoppingList createdShoppingList = this.shoppingListService.create(body);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdShoppingList.getShoppingListId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(value = "/shopping-lists")
	public List<ShoppingList> getAll() {
		return this.shoppingListService.getAll();
	}

	@GetMapping(value = "/shopping-lists/{shoppingListId}")
	public ShoppingList get(@PathVariable UUID shoppingListId) {
		Optional<ShoppingList> shoppingList = this.shoppingListService.get(shoppingListId);
		if (shoppingList.isEmpty()) {
			throw new IllegalArgumentException("Shopping list not found");
		}
		return shoppingList.get();
	}

	@PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails")
	public ResponseEntity<Void> addCocktail(@PathVariable UUID shoppingListId,
			@RequestBody ShoppingListBodyAddCocktail body) {

		Cocktail cocktail = this.shoppingListService.addCocktail(shoppingListId, body);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cocktail.getCocktailId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IllegalArgumentException.class)
	public void handleNotFound(Exception ex) {
		logger.error(ex.getMessage());
		// return empty 404
	}

}
