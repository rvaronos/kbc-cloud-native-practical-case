package com.ezgroceries.shoppinglist.api.cocktail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CocktailService {

    public List<Cocktail> getAll(String query);

    public Optional<Cocktail> get(UUID id);
}
