package com.ezgroceries.shoppinglist.api.cocktail;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CocktailMock {

    public List<Cocktail> cocktails;

    public static List<Cocktail> getCocktailList() {
        List<Cocktail> cocktails = new ArrayList<Cocktail>();
        Cocktail cocktailMargerita = new Cocktail();
        cocktailMargerita.setCocktailId(UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"));
        cocktailMargerita.setName("Margerita");
        cocktailMargerita.setGlass("Cocktail glass");
        cocktailMargerita.setInstructions(
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..");
        cocktailMargerita.setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        cocktailMargerita.setIngredients(new String[] { "Tequila", "Triple sec", "Lime juice", "Salt" });
        cocktails.add(cocktailMargerita);

        Cocktail cocktailBlueMargerita = new Cocktail();
        cocktailBlueMargerita.setCocktailId(UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"));
        cocktailBlueMargerita.setName("Blue Margerita");
        cocktailBlueMargerita.setGlass("Cocktail glass");
        cocktailBlueMargerita.setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..");
        cocktailBlueMargerita.setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg");
        cocktailBlueMargerita.setIngredients(new String[] { "Tequila", "Blue Curacao", "Lime juice", "Salt" });
        cocktails.add(cocktailBlueMargerita);

        return cocktails;
    }

}
