package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.CocktailService;
import com.ezgroceries.shoppinglist.api.cocktail.api.CocktailAPIRepository;

import lombok.RequiredArgsConstructor;

@Service
@ConditionalOnProperty(prefix = "service", name = "cocktail", havingValue = "db")
@RequiredArgsConstructor
public class CocktailDBService implements CocktailService {

    private final CocktailAPIRepository cocktailAPI;

    private final CocktailDBRepository cocktailDBRepository;

    @Override
    public List<Cocktail> getAll(String query) {
        List<Cocktail> cocktails = this.cocktailAPI.getAll(query);
        cocktails.stream().forEach(cocktail -> {
            if (this.cocktailDBRepository.existsById(cocktail.getCocktailId())) {
                return;
            }
            CocktailDBEntity cocktailDBEntity = new CocktailDBEntity();
            cocktailDBEntity.setId(cocktail.getCocktailId());
            cocktailDBEntity.setIdDrink(cocktail.getApiId());
            cocktailDBEntity.setName(cocktail.getName());
            cocktailDBEntity.setIngredients(cocktail.getIngredients());
            cocktailDBEntity.setGlass(cocktail.getGlass());
            cocktailDBEntity.setInstructions(cocktail.getInstructions());
            cocktailDBEntity.setImageLink(cocktail.getImage());
            this.cocktailDBRepository.save(cocktailDBEntity);
        });
        return cocktails;
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
