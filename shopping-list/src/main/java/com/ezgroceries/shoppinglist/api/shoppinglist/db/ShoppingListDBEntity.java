package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;

import lombok.Data;

@Entity
@Table(name = "shopping_list")
@Data
public class ShoppingListDBEntity {

    @Id
    @Column
    private UUID id;

    @Column
    private String name;

    public ShoppingList output() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setShoppingListId(this.getId());
        shoppingList.setName(this.getName());
        return shoppingList;
    }

}