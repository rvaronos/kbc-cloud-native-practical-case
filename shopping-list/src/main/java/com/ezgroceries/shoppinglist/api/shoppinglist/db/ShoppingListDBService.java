package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db.CocktailShoppingListDBEmbeddableId;
import com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db.CocktailShoppingListDBEntity;
import com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db.CocktailShoppingListDBRepository;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "db")
public class ShoppingListDBService implements ShoppingListService {

    @Autowired
    private ShoppingListDBRepository shoppingListDBRepository;

    @Autowired
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
    public void addCocktail(UUID shoppingListId, ShoppingListBodyAddCocktail body) {

        CocktailShoppingListDBEntity cocktailShoppingListDBEntity = new CocktailShoppingListDBEntity();
        CocktailShoppingListDBEmbeddableId cocktailShoppingListDBEmbeddableId = new CocktailShoppingListDBEmbeddableId();
        cocktailShoppingListDBEmbeddableId.setCocktail_id(body.getCocktailId());
        cocktailShoppingListDBEmbeddableId.setShopping_list_id(shoppingListId);
        cocktailShoppingListDBEntity.setId(cocktailShoppingListDBEmbeddableId);

        CocktailShoppingListDBEntity savedCocktailShoppingListDBEntity = this.cocktailShoppingListDBRepository
                .save(cocktailShoppingListDBEntity);
    }

}