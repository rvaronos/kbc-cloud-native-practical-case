package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListCreateRequestBody;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;

@Service
@ConditionalOnProperty(prefix = "service", name = "shoppingList", havingValue = "db")
public class ShoppingListDBService implements ShoppingListService {

    @Autowired
    private ShoppingListDBRepository shoppingListDBRepository;

    @Override
    public ShoppingList create(ShoppingListCreateRequestBody requestBody) {
        ShoppingListDBEntity shoppingListDBEntity = new ShoppingListDBEntity();
        shoppingListDBEntity.setId(UUID.randomUUID());
        shoppingListDBEntity.setName(requestBody.getName());
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
        // TODO Auto-generated method stub
        return null;
    }

}