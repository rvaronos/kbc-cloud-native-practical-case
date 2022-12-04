package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.db.ShoppingListDBEntity;
import com.ezgroceries.shoppinglist.common.converter.StringSetConverter;

import lombok.Data;

@Entity
@Table(name = "cocktail")
@Data
public class CocktailDBEntity {

    @Id
    @Column()
    private UUID id;

    @Column()
    private String idDrink;

    @Column()
    private String name;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

    @ManyToMany(mappedBy = "cocktails")
    private Set<ShoppingListDBEntity> shoppingLists = new HashSet<>();

    public Cocktail output() {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailId(this.getId());
        return cocktail;
    }

}