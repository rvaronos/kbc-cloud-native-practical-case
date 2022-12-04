package com.ezgroceries.shoppinglist.api.shoppinglist.dummy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.dummy.CocktailDummyService;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "dummy")
public class ShoppingListDummyService implements ShoppingListService {

    private List<ShoppingList> shoppingLists = Lists.newArrayList(getStephanieShoppingList(),
            getBirthdayShoppingList());

    @Override
    public ShoppingList create(ShoppingListBodyCreate requestBody) {

        ShoppingList createdShoppingList = new ShoppingList();
        createdShoppingList.setShoppingListId(UUID.fromString("c16acb4d-c85e-43db-a006-5f8d99a97aa2"));
        createdShoppingList.setName(requestBody.getName());

        return createdShoppingList;

    }

    @Override
    public Optional<ShoppingList> get(UUID shoppingListId) {

        return this.shoppingLists.stream()
                .filter(shoppingList -> shoppingList.getShoppingListId().equals(shoppingListId))
                .findFirst();
    }

    @Override
    public List<ShoppingList> getAll() {
        return shoppingLists;
    }

    @Override
    public Cocktail addCocktail(UUID shoppingListId, ShoppingListBodyAddCocktail body) {

        Cocktail newCocktail = new Cocktail();
        newCocktail.setCocktailId(UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"));
        newCocktail.setIngredients(Sets.newHashSet("Triple sec"));

        return newCocktail;
    }

    private static ShoppingList getStephanieShoppingList() {
        ShoppingList stephanieShoppingList = new ShoppingList();
        stephanieShoppingList.setShoppingListId(UUID.fromString("00611cca-2076-446b-89e8-0f53735a7a5a"));
        stephanieShoppingList.setName("Stephanie's birthday");
        stephanieShoppingList.setCocktails(Sets.newHashSet(
                CocktailDummyService.getCocktailMargerita(),
                CocktailDummyService.getCocktailBlueMargerita()));
        return stephanieShoppingList;
    }

    private static ShoppingList getBirthdayShoppingList() {
        ShoppingList birthdayShoppingList = new ShoppingList();
        birthdayShoppingList.setShoppingListId(UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"));
        birthdayShoppingList.setName("My Birthday");
        birthdayShoppingList.setCocktails(Sets.newHashSet(
                CocktailDummyService.getCocktailMargerita()));
        return birthdayShoppingList;
    }

}
