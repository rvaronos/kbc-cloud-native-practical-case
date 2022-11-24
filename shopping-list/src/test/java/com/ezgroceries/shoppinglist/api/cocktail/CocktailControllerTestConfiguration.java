package com.ezgroceries.shoppinglist.api.cocktail;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.ezgroceries.shoppinglist.api.cocktail.dummy.CocktailDummyService;

@TestConfiguration
public class CocktailControllerTestConfiguration {

        @Bean
        public CocktailService cocktailService() {
                return new CocktailDummyService();
        };

}
