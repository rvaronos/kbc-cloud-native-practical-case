package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.google.common.base.Optional;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CocktailAPIRepository {

    private CocktailAPIClient cocktailDBClient;

    public List<Cocktail> getAll(String query) {
        ResponseEntity<CocktailAPIResponseSearch> response = this.cocktailDBClient.searchCocktails(query);
        CocktailAPIResponseSearch responseBody = response.getBody();

        if (responseBody == null) {
            return new ArrayList<Cocktail>();
        }

        List<CocktailAPIResource> drinks = responseBody.getDrinks();

        if (drinks == null) {
            return new ArrayList<Cocktail>();
        }

        return drinks.stream()
                .map((drink) -> CocktailAPIMapper.mapCocktail(drink))
                .collect(Collectors.toList());
    }

    public Optional<Cocktail> get(String id) {
        ResponseEntity<CocktailAPIResponseLookup> response = this.cocktailDBClient.getCocktail(id);
        CocktailAPIResponseLookup responseBody = response.getBody();

        if (responseBody == null) {
            return Optional.absent();
        }

        List<CocktailAPIResource> drinks = responseBody.getDrinks();
        CocktailAPIResource cocktailAPIResource = drinks.get(0);
        return Optional.of(CocktailAPIMapper.mapCocktail(cocktailAPIResource));
    }

}
