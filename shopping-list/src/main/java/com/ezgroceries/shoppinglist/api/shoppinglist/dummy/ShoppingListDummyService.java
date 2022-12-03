package com.ezgroceries.shoppinglist.api.shoppinglist.dummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "dummy")
public class ShoppingListDummyService implements ShoppingListService {

    @Override
    public ShoppingList create(ShoppingListBodyCreate requestBody) {

        ShoppingList createdShoppingList = new ShoppingList();
        createdShoppingList.setShoppingListId(UUID.fromString("c16acb4d-c85e-43db-a006-5f8d99a97aa2"));
        createdShoppingList.setName(requestBody.getName());

        return createdShoppingList;

    }

    @Override
    public Optional<ShoppingList> get(UUID shoppingListId) {

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

        return Optional.of(fetchedShoppingList);
    }

    @Override
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

    @Override
    public void addCocktail(UUID shoppingListId, ShoppingListBodyAddCocktail body) {
        // TODO Auto-generated method stub

    }

}
