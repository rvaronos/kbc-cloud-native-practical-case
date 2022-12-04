package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.db.CocktailDBEntity;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingList;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_list")
public class ShoppingListDBEntity {

    @Id
    @Column
    @Getter
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cocktail_shopping_list", joinColumns = {
            @JoinColumn(name = "shopping_list_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "cocktail_id") })
    @Getter
    @Setter
    Set<CocktailDBEntity> cocktails = new HashSet<>();

    public ShoppingList output() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setShoppingListId(this.getId());
        shoppingList.setName(this.getName());
        shoppingList.setCocktails(this.cocktails.stream().map(cocktail -> cocktail.output())
                .collect(Collectors.toCollection(HashSet::new)));
        return shoppingList;
    }

}