package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIClient;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResource;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponseLookup;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponseSearch;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CocktailDBClientFallback implements CocktailAPIClient {

    private final CocktailDBRepository cocktailDBRepository;

    @Override
    public ResponseEntity<CocktailAPIResponseSearch> searchCocktails(String search) {
        List<CocktailDBEntity> cocktailEntities = cocktailDBRepository.findByNameContainingIgnoreCase(search);
        List<CocktailAPIResource> cocktailAPIResources = cocktailEntities.stream()
                .map((cocktailDBEntity) -> this.mapCocktailDBEntity(cocktailDBEntity)).collect(Collectors.toList());
        CocktailAPIResponseSearch cocktailAPIResponseSearch = CocktailAPIResponseSearch.builder()
                .drinks(cocktailAPIResources).build();
        return new ResponseEntity<CocktailAPIResponseSearch>(cocktailAPIResponseSearch, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CocktailAPIResponseLookup> getCocktail(String id) {

        CocktailAPIResponseLookup cocktailAPIResponseLookup = CocktailAPIResponseLookup.builder().build();

        return new ResponseEntity<CocktailAPIResponseLookup>(cocktailAPIResponseLookup, HttpStatus.OK);
    }

    private CocktailAPIResource mapCocktailDBEntity(CocktailDBEntity cocktailDBEntity) {
        return CocktailAPIResource.builder()
                .idDrink(cocktailDBEntity.getIdDrink())
                .strDrink(cocktailDBEntity.getName())
                .strInstructions(cocktailDBEntity.getInstructions())
                .strGlass(cocktailDBEntity.getGlass())
                .strDrinkThumb(cocktailDBEntity.getIdDrink())
                .build();
    }

}
