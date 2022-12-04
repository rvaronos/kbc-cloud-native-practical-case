package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Setter;

@Data
public class ShoppingList {
    private UUID shoppingListId;
    private String name;
    @Setter
    private Set<String> ingredients = new HashSet<>();
    @JsonIgnore
    private Set<Cocktail> cocktails = new HashSet<>();

    public Set<String> getIngredients() {
        HashSet<String> ingredients = new HashSet<String>();
        if (this.cocktails == null) {
            return new HashSet<>();
        }
        this.cocktails.stream().forEach((cocktail -> {
            cocktail.getIngredients().stream().forEach(ingredient -> {
                ingredients.add(ingredient);
            });
        }));
        return ingredients;
    }
}
