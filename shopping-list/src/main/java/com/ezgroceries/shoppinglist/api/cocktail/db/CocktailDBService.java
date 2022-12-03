package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIRepository;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "db")
public class CocktailDBService implements CocktailService {

    @Autowired
    private CocktailAPIRepository cocktailAPI;

    @Autowired
    private CocktailDBRepository cocktailDBRepository;

    @Override
    public List<Cocktail> getAll(String query) {
        return this.cocktailAPI.getAll(query);
    }

    @Override
    public Optional<Cocktail> get(UUID id) {
        Optional<CocktailDBEntity> cocktailDBEntity = this.cocktailDBRepository.findById(id);
        if (cocktailDBEntity.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(cocktailDBEntity.get().output());
    }

}
