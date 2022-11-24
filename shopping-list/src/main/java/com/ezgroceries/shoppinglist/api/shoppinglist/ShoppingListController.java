package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShoppingListController {

	@Autowired
	private ShoppingListService shoppingListService;

	@PostMapping(value = "/shopping-lists")
	public ResponseEntity<Void> create(@RequestBody ShoppingListCreateRequestBody body) {

		ShoppingList createdShoppingList = this.shoppingListService.create(body);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdShoppingList.getShoppingListId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(value = "/shopping-lists")
	public List<ShoppingList> getAll() {

		List<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

		ShoppingList stephanieShoppingList = new ShoppingList();
		stephanieShoppingList.setShoppingListId(UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"));
		stephanieShoppingList.setName("Stephanie's birthday");
		stephanieShoppingList.setIngredients(new String[] {
				"Tequila",
				"Triple sec",
				"Lime juice",
				"Salt",
				"Blue Curacao"
		});
		shoppingLists.add(stephanieShoppingList);

		ShoppingList birthdayShoppingList = new ShoppingList();
		birthdayShoppingList.setShoppingListId(UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"));
		birthdayShoppingList.setName("My Birthday");
		birthdayShoppingList.setIngredients(new String[] {
				"Tequila",
				"Triple sec",
				"Lime juice",
				"Salt",
				"Blue Curacao"
		});
		shoppingLists.add(birthdayShoppingList);

		return shoppingLists;

	}

	@GetMapping(value = "/shopping-lists/{shoppingListId}")
	public ShoppingList get(@PathVariable UUID shoppingListId) {
		ShoppingList fetchedShoppingList = new ShoppingList();
		fetchedShoppingList.setShoppingListId(shoppingListId);
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
