package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CocktailAPIResponseLookup {
    private List<CocktailAPIResource> drinks;
}
