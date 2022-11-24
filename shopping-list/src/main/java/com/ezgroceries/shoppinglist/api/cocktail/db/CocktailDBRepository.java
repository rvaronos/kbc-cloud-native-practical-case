package com.ezgroceries.shoppinglist.api.cocktail.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CocktailDBRepository {

    @Autowired
    private DataSource dataSource;

}
