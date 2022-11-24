package com.ezgroceries.shoppinglist.api.cocktail;

import lombok.Data;

@Data
public class Cocktail {
    private String cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private String[] ingredients;
}
