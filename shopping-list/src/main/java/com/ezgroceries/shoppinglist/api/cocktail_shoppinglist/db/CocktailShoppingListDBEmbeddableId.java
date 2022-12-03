package com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CocktailShoppingListDBEmbeddableId implements Serializable {

    private UUID cocktail_id;
    private UUID shopping_list_id;

}