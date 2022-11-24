package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingListDBEntity {

    @Id
    @Column()
    private UUID id;

}