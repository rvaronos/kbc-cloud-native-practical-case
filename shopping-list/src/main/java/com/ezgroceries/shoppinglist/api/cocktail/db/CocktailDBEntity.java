package com.ezgroceries.shoppinglist.api.cocktail.db;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ezgroceries.shoppinglist.common.converter.StringSetConverter;

@Entity
@Table(name = "cocktail")
public class CocktailDBEntity {

    @Id
    @Column()
    private UUID id;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

}