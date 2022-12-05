package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocktailAPIResponseSearch {
    private List<CocktailAPIResource> drinks;
}
