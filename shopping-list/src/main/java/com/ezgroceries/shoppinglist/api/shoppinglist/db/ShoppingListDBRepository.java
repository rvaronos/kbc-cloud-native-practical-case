package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import org.springframework.stereotype.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ShoppingListDBRepository extends JpaRepository<ShoppingListDBEntity, UUID> {

}
