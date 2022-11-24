package com.ezgroceries.shoppinglist.api.shoppinglist.dummy;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListCreateRequestBody;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;

@Component
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "dummy")
public class ShoppingListDummyService implements ShoppingListService {

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
