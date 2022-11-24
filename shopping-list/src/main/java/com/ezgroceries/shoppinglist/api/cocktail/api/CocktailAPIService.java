package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIResponse.DrinkResource;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "api")
public class CocktailAPIService implements CocktailService {

    @Autowired
    private CocktailAPIClient cocktailDBClient;

    @Override
    public List<Cocktail> getAll(String query) {
        ResponseEntity<CocktailAPIResponse> response = this.cocktailDBClient.searchCocktails(query);

        List<DrinkResource> drinks = response.getBody().getDrinks();

        if (drinks == null) {
            return new ArrayList<Cocktail>();
        }

        return drinks.stream()
                .map((drink) -> mapCocktail(drink))
                .collect(Collectors.toList());
    }

    private Cocktail mapCocktail(DrinkResource dbDrink) {

        String[] allIngredients = {
                dbDrink.getStrIngredient1(),
                dbDrink.getStrIngredient2(),
                dbDrink.getStrIngredient3(),
                dbDrink.getStrIngredient4(),
                dbDrink.getStrIngredient5(),
                dbDrink.getStrIngredient6(),
                dbDrink.getStrIngredient7(),
                dbDrink.getStrIngredient8(),
                dbDrink.getStrIngredient9(),
                dbDrink.getStrIngredient10(),
                dbDrink.getStrIngredient11(),
                dbDrink.getStrIngredient12(),
                dbDrink.getStrIngredient13(),
                dbDrink.getStrIngredient14(),
                dbDrink.getStrIngredient15(),
        };

        String[] filteredIngredients = Stream.of(allIngredients).filter(ingredient -> ingredient != null)
                .toArray(String[]::new);

        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailId(dbDrink.getIdDrink());
        cocktail.setName(dbDrink.getStrDrink());
        cocktail.setIngredients(filteredIngredients);
        cocktail.setInstructions(dbDrink.getStrInstructions());
        cocktail.setGlass(dbDrink.getStrGlass());
        cocktail.setImage(dbDrink.getStrDrinkThumb());

        return cocktail;
    }

}
