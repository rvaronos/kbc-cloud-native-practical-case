package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "api")
public class CocktailAPIService implements CocktailService {

    @Autowired
    private CocktailAPIRepository cocktailAPIRepository;

    @Override
    public List<Cocktail> getAll(String query) {
        return this.cocktailAPIRepository.getAll(query);
    }

    @Override
    public Optional<Cocktail> get(UUID id) {
        return Optional.empty();
    }

}
