package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;

public interface ShoppingListService {
    public ShoppingList create(ShoppingListBodyCreate body);

    public Optional<ShoppingList> get(UUID shoppingListId);

    public List<ShoppingList> getAll();

    public ShoppingList addCocktail(ShoppingListBodyAddCocktail body);
}
