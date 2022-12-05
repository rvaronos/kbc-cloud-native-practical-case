package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;

import lombok.RequiredArgsConstructor;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "api")
@RequiredArgsConstructor
public class CocktailAPIService implements CocktailService {

    private final CocktailAPIRepository cocktailAPIRepository;

    @Override
    public List<Cocktail> getAll(String query) {
        return this.cocktailAPIRepository.getAll(query);
    }

    @Override
    public Optional<Cocktail> get(UUID id) {
        return Optional.empty();
    }

}
