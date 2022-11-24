package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListCreateRequestBody;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "db")
public class ShoppingListDBService implements ShoppingListService {

    @Autowired
    private ShoppingListDBRepository shoppingListDBRepository;

    @Override
    public ShoppingList create(ShoppingListCreateRequestBody requestBody) {
        // TODO Auto-generated method stub
        return null;
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