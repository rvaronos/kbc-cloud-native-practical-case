package com.ezgroceries.shoppinglist;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListService;
import com.ezgroceries.shoppinglist.api.shoppinglist.ShoppingListServiceDummy;

@Configuration
public class ShoppingListConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "service", name = "data", havingValue = "dummy")
    public ShoppingListService shoppingListServiceDummy() {
        return new ShoppingListServiceDummy();
    }
}
