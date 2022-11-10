package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShoppingListController {

	@PostMapping(value = "/shopping-lists")
	@ResponseStatus(code = HttpStatus.CREATED)
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

}
