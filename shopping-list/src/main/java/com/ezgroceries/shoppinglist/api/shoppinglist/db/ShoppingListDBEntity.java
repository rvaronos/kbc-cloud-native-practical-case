package com.ezgroceries.shoppinglist.api.shoppinglist.db;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shopping_list")
@Data
public class ShoppingListDBEntity {

    @Id
    @Column
    private UUID id;

    @Column
    private String name;

}