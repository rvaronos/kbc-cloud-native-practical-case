package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponse.DrinkResource;

@Repository
public class CocktailAPIRepository {

    @Autowired
    private CocktailAPIClient cocktailDBClient;

    public List<Cocktail> getAll(String query) {
        ResponseEntity<CocktailAPIResponse> response = this.cocktailDBClient.searchCocktails(query);
        CocktailAPIResponse responseBody = response.getBody();

        if (responseBody == null) {
            return new ArrayList<Cocktail>();
        }

        List<DrinkResource> drinks = responseBody.getDrinks();

        if (drinks == null) {
            return new ArrayList<Cocktail>();
        }

        return drinks.stream()
                .map((drink) -> CocktailAPIMapper.mapCocktail(drink))
                .collect(Collectors.toList());
    }

}
