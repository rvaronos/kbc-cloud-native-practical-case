package com.ezgroceries.shoppinglist.api.cocktail.api;

import java.util.List;

import lombok.Data;

public class CocktailAPIResponse {
    private List<DrinkResource> drinks;

    public List<DrinkResource> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkResource> drinks) {
        this.drinks = drinks;
    }

    @Data
    public static class DrinkResource {
        private String idDrink;
        private String strDrink;
        private String strDrinkThumb;
        private String strGlass;
        private String strIngredient1;
        private String strIngredient2;
        private String strIngredient3;
        private String strIngredient4;
        private String strIngredient5;
        private String strIngredient6;
        private String strIngredient7;
        private String strIngredient8;
        private String strIngredient9;
        private String strIngredient10;
        private String strIngredient11;
        private String strIngredient12;
        private String strIngredient13;
        private String strIngredient14;
        private String strIngredient15;
        private String strInstructions;
    }
}
