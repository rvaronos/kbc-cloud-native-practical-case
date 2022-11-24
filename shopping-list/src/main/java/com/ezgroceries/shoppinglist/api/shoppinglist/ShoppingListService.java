package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingListService {
    public ShoppingList create(ShoppingListCreateRequestBody requestBody);

    public Optional<ShoppingList> get(UUID shoppingListId);

    public List<ShoppingList> getAll();
}
