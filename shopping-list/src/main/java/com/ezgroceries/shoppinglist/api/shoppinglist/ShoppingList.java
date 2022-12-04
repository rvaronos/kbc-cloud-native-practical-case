package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

@Data
public class ShoppingList {
    private UUID shoppingListId;
    private String name;
    private Set<String> ingredients;
}
