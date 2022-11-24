package com.ezgroceries.shoppinglist.api.cocktail;

import java.util.List;

public interface CocktailService {

    public List<Cocktail> getAll(String query);
}
