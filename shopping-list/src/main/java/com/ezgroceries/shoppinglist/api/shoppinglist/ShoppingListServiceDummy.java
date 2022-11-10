package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.List;
import java.util.UUID;

public class ShoppingListServiceDummy implements ShoppingListService {

    @Override
    public ShoppingList create(ShoppingListCreateRequestBody requestBody) {

        ShoppingList createdShoppingList = new ShoppingList();
        createdShoppingList.setShoppingListId(UUID.randomUUID());
        createdShoppingList.setName(requestBody.getName());

        return createdShoppingList;

    }

    @Override
    public ShoppingList get(String shoppingListId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ShoppingList> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
