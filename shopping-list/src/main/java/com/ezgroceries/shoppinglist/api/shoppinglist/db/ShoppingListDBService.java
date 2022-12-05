package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBEntity;
import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBRepository;
import com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db.CocktailShoppingListDBEntity;
import com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db.CocktailShoppingListDBRepository;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;

import lombok.RequiredArgsConstructor;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "db")
@RequiredArgsConstructor
public class ShoppingListDBService implements ShoppingListService {

    private ShoppingListDBRepository shoppingListDBRepository;
    private CocktailDBRepository cocktailDBRepository;
    private CocktailShoppingListDBRepository cocktailShoppingListDBRepository;

    @Override
    public ShoppingList create(ShoppingListBodyCreate body) {
        ShoppingListDBEntity shoppingListDBEntity = new ShoppingListDBEntity();
        shoppingListDBEntity.setId(UUID.randomUUID());
        shoppingListDBEntity.setName(body.getName());
        ShoppingListDBEntity savedShoppingListDBEntity = this.shoppingListDBRepository.save(shoppingListDBEntity);

        return savedShoppingListDBEntity.output();
    }

    @Override
    public Optional<ShoppingList> get(UUID shoppingListId) {
        Optional<ShoppingListDBEntity> shoppingListDBEntity = this.shoppingListDBRepository.findById(shoppingListId);
        if (shoppingListDBEntity.isPresent()) {
            return Optional.of(shoppingListDBEntity.get().output());
        }

        return Optional.empty();
    }

    @Override
    public List<ShoppingList> getAll() {
        List<ShoppingListDBEntity> shoppingListDBEntityList = this.shoppingListDBRepository.findAll();

        return shoppingListDBEntityList.stream().map((shoppingListDBEntity) -> shoppingListDBEntity.output())
                .collect(Collectors.toList());
    }

    @Override
    public Cocktail addCocktail(UUID shoppingListId, ShoppingListBodyAddCocktail body) {

        Optional<CocktailDBEntity> cocktailDBEntity = this.cocktailDBRepository.findById(body.getCocktailId());
        Optional<ShoppingListDBEntity> shoppingListDBEntity = this.shoppingListDBRepository.findById(shoppingListId);

        if (cocktailDBEntity.isEmpty()) {
            throw new IllegalArgumentException("cocktail not found");
        }

        if (shoppingListDBEntity.isEmpty()) {
            throw new IllegalArgumentException("shopping list not found");
        }

        CocktailShoppingListDBEntity cocktailShoppingListDBEntity = new CocktailShoppingListDBEntity(
                cocktailDBEntity.get(), shoppingListDBEntity.get());

        this.cocktailShoppingListDBRepository
                .save(cocktailShoppingListDBEntity);

        return cocktailDBEntity.get().output();
    }

}