package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBEntity;
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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "cocktail_shopping_list", joinColumns = {
            @JoinColumn(name = "shopping_list_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "cocktail_id") })
    Set<CocktailDBEntity> cocktails = new HashSet<>();

    public ShoppingList output() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setShoppingListId(this.getId());
        shoppingList.setName(this.getName());
        return shoppingList;
    }

}