package com.ezgroceries.shoppinglist.api.cocktail_shoppinglist.db;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CocktailShoppingListDBRepository
        extends JpaRepository<CocktailShoppingListDBEntity, CocktailShoppingListDBEmbeddableId> {

}
