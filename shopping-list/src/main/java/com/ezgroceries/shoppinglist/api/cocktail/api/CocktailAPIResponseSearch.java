package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;

import lombok.Data;

@Data
public class CocktailAPIResponseSearch {
    private List<CocktailAPIResource> drinks;
}
