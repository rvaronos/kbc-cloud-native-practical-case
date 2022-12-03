package com.ezgroceries.shoppinglist.api.cocktail.dummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "dummy")
public class CocktailDummyService implements CocktailService {

    public List<Cocktail> cocktails;

    private Cocktail margerita = getCocktailMargerita();
    private Cocktail blueMargerita = getCocktailBlueMargerita();

    @Override
    public List<Cocktail> getAll(String query) {
        List<Cocktail> cocktails = new ArrayList<Cocktail>();

        cocktails.add(margerita);
        cocktails.add(blueMargerita);

        return cocktails;
    }

    @Override
    public Optional<Cocktail> get(UUID id) {
        if (id == margerita.getCocktailId()) {
            return Optional.of(margerita);
        }
        if (id == blueMargerita.getCocktailId()) {
            return Optional.of(blueMargerita);
        }
        return Optional.empty();
    }

    private static Cocktail getCocktailMargerita() {
        Cocktail cocktailMargerita = new Cocktail();
        cocktailMargerita.setCocktailId(UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"));
        cocktailMargerita.setApiId("23b3d85a-3928-41c0-a533-6538a71e17c4");
        cocktailMargerita.setName("Margerita");
        cocktailMargerita.setGlass("Cocktail glass");
        cocktailMargerita.setInstructions(
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..");
        cocktailMargerita.setImage("https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg");
        cocktailMargerita.setIngredients(new String[] { "Tequila", "Triple sec", "Lime juice", "Salt" });
        return cocktailMargerita;
    }

    private static Cocktail getCocktailBlueMargerita() {
        Cocktail cocktailBlueMargerita = new Cocktail();
        cocktailBlueMargerita.setCocktailId(UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"));
        cocktailBlueMargerita.setApiId("23b3d85a-3928-41c0-a533-6538a71e17c4");
        cocktailBlueMargerita.setName("Blue Margerita");
        cocktailBlueMargerita.setGlass("Cocktail glass");
        cocktailBlueMargerita.setInstructions("Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..");
        cocktailBlueMargerita.setImage("https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg");
        cocktailBlueMargerita.setIngredients(new String[] { "Tequila", "Blue Curacao", "Lime juice", "Salt" });
        return cocktailBlueMargerita;

    }

}
