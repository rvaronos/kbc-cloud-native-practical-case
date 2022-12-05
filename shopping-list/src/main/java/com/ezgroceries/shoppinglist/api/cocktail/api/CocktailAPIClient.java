package com.ezgroceries.shoppinglist.api.cocktail.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBClientFallback;

@Component
@FeignClient(name = "cocktailDBClient", url = "https://www.thecocktaildb.com/api/json/v1/1", fallback = CocktailDBClientFallback.class)
public interface CocktailAPIClient {

    @GetMapping(value = "search.php")
    ResponseEntity<CocktailAPIResponseSearch> searchCocktails(@RequestParam("s") String search);

    @GetMapping(value = "lookup.php")
    ResponseEntity<CocktailAPIResponseLookup> getCocktail(@RequestParam("i") String id);

}