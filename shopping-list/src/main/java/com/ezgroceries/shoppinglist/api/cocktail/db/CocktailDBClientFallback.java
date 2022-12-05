package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIClient;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResource;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponseLookup;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponseSearch;
import com.google.common.collect.Lists;

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

        CocktailDBEntity cocktailDBEntity = cocktailDBRepository.findByIdDrink(id);
        CocktailAPIResource cocktailAPIResource = mapCocktailDBEntity(cocktailDBEntity);

        CocktailAPIResponseLookup cocktailAPIResponseLookup = CocktailAPIResponseLookup.builder()
                .drinks(Lists.asList(cocktailAPIResource, null)).build();

        return new ResponseEntity<CocktailAPIResponseLookup>(cocktailAPIResponseLookup, HttpStatus.OK);
    }

    private CocktailAPIResource mapCocktailDBEntity(CocktailDBEntity cocktailDBEntity) {

        String[] ingredients = cocktailDBEntity.getIngredients().toArray(new String[15]);

        return CocktailAPIResource.builder()
                .idDrink(cocktailDBEntity.getIdDrink())
                .strDrink(cocktailDBEntity.getName())
                .strInstructions(cocktailDBEntity.getInstructions())
                .strGlass(cocktailDBEntity.getGlass())
                .strDrinkThumb(cocktailDBEntity.getIdDrink())
                .strIngredient1(ingredients[0])
                .strIngredient2(ingredients[1])
                .strIngredient3(ingredients[2])
                .strIngredient4(ingredients[3])
                .strIngredient5(ingredients[4])
                .strIngredient6(ingredients[5])
                .strIngredient7(ingredients[6])
                .strIngredient8(ingredients[7])
                .strIngredient9(ingredients[8])
                .strIngredient10(ingredients[9])
                .strIngredient11(ingredients[10])
                .strIngredient12(ingredients[11])
                .strIngredient13(ingredients[12])
                .strIngredient14(ingredients[13])
                .strIngredient15(ingredients[14])
                .build();
    }

}
