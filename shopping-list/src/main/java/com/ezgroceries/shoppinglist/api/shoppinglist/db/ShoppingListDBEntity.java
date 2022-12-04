package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBEntity;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_list")
public class ShoppingListDBEntity {

    @Id
    @Column
    @Getter
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(name = "cocktail_shopping_list", joinColumns = {
            @JoinColumn(name = "shopping_list_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "cocktail_id") })
    @Getter
    @Setter
    Set<CocktailDBEntity> cocktails = new HashSet<>();

    public ShoppingList output() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setShoppingListId(this.getId());
        shoppingList.setName(this.getName());
        shoppingList.setIngredients(this.getIngredientsFromCocktails());
        return shoppingList;
    }

    private Set<String> getIngredientsFromCocktails() {
        HashSet<String> ingredients = new HashSet<String>();
        this.cocktails.stream().forEach((cocktail -> {
            cocktail.getIngredients().stream().forEach(ingredient -> {
                ingredients.add(ingredient);
            });
        }));
        return ingredients;
    }

}