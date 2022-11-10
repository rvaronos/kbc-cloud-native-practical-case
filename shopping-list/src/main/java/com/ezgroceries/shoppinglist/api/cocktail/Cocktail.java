package com.ezgroceries.shoppinglist.api.cocktail;

import java.util.UUID;

import lombok.Data;

@Data
public class Cocktail {
    private UUID cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private String[] ingredients;
}
