package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.List;

public interface ShoppingListService {
    public ShoppingList create(ShoppingListCreateRequestBody requestBody);

    public ShoppingList get(String shoppingListId);

    public List<ShoppingList> getAll();
}
