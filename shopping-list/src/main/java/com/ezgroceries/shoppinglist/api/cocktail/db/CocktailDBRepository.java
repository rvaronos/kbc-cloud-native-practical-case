package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CocktailDBRepository extends JpaRepository<CocktailDBEntity, UUID> {

}
