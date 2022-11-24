package com.ezgroceries.shoppinglist.api.shoppinglist;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.ezgroceries.shoppinglist.api.shoppinglist.dummy.ShoppingListDummyService;

@TestConfiguration
public class ShoppingListControllerTestConfiguration {

        @Bean
        public ShoppingListService shoppingListService() {
                return new ShoppingListDummyService();
        };

}
