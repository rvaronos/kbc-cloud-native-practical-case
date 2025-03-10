package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;

public class CocktailAPIMapper {

    public static Cocktail mapCocktail(CocktailAPIResource dbDrink) {

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

        HashSet<String> filteredIngredients = Stream.of(allIngredients).filter(ingredient -> ingredient != null)
                .collect(Collectors.toCollection(HashSet::new));

        UUID cocktailId = UUID.nameUUIDFromBytes(dbDrink.getIdDrink().getBytes());
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailId(cocktailId);
        cocktail.setApiId(dbDrink.getIdDrink());
        cocktail.setName(dbDrink.getStrDrink());
        cocktail.setIngredients(filteredIngredients);
        cocktail.setInstructions(dbDrink.getStrInstructions());
        cocktail.setGlass(dbDrink.getStrGlass());
        cocktail.setImage(dbDrink.getStrDrinkThumb());

        return cocktail;
    }

}
