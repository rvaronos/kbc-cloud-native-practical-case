package com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBEntity;
import com.ezgroceries.shoppinglist.api.shoppinglist.db.ShoppingListDBEntity;

import lombok.Data;

@Entity
@Table(name = "cocktail_shopping_list")
@Data
public class CocktailShoppingListDBEntity {

    @EmbeddedId
    private CocktailShoppingListDBEmbeddableId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cocktail_id")
    private CocktailDBEntity cocktail;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopping_list_id")
    private ShoppingListDBEntity shoppingList;

    public CocktailShoppingListDBEntity() {
    }

    public CocktailShoppingListDBEntity(CocktailDBEntity cocktail, ShoppingListDBEntity shoppingList) {
        this.cocktail = cocktail;
        this.shoppingList = shoppingList;

        CocktailShoppingListDBEmbeddableId id = new CocktailShoppingListDBEmbeddableId();
        id.setCocktail_id(cocktail.getId());
        id.setShopping_list_id(shoppingList.getId());

        this.id = id;
    }

}