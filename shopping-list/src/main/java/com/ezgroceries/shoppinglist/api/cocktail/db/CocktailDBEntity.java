package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.api.cocktail.Cocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.db.ShoppingListDBEntity;
import com.ezgroceries.shoppinglist.common.converter.StringSetConverter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cocktail")
public class CocktailDBEntity {

    @Id
    @Column
    @Getter
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String idDrink;

    @Column
    @Getter
    @Setter
    private String name;

    @Convert(converter = StringSetConverter.class)
    @Getter
    @Setter
    private Set<String> ingredients;

    @Column
    @Getter
    @Setter
    private String glass;

    @Column
    @Getter
    @Setter
    private String instructions;

    @Column
    @Getter
    @Setter
    private String imageLink;

    @ManyToMany(mappedBy = "cocktails", fetch = FetchType.LAZY)
    private Set<ShoppingListDBEntity> shoppingLists = new HashSet<>();

    public Cocktail output() {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailId(this.getId());
        cocktail.setIngredients(this.getIngredients());
        cocktail.setName(this.getName());
        return cocktail;
    }

}