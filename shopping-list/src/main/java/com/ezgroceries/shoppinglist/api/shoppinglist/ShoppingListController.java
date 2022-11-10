package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShoppingListController {

	@PostMapping(value = "/shopping-lists")
	public ResponseEntity<Void> create(@RequestBody ShoppingListCreateRequestBody body) {
		ShoppingList createdShoppingList = new ShoppingList();
		createdShoppingList.setShoppingListId(UUID.randomUUID());
		createdShoppingList.setName(body.getName());

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdShoppingList.getShoppingListId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(value = "/shopping-lists/{shoppingListId}")
	public ShoppingList get(@PathVariable UUID shoppingListId) {
		ShoppingList fetchedShoppingList = new ShoppingList();
		fetchedShoppingList.setShoppingListId(UUID.randomUUID());
		fetchedShoppingList.setName("Stephanie's birthday");
		fetchedShoppingList.setIngredients(new String[] {
				"Tequila",
				"Triple sec",
				"Lime juice",
				"Salt",
				"Blue Curacao"
		});

		return fetchedShoppingList;

	}

}
