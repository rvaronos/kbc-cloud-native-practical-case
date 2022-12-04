package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyAddCocktail;
import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;

@WebMvcTest(ShoppingListController.class)
@Import(ShoppingListControllerTestConfiguration.class)
public class ShoppingListControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testCreate() throws Exception {

                ShoppingListBodyCreate requestBody = new ShoppingListBodyCreate();
                requestBody.setName("Stephanie's birthday");

                Gson requestBodyGson = new Gson();

                String requestBodyJson = requestBodyGson.toJson(requestBody);

                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setShoppingListId(UUID.fromString("c16acb4d-c85e-43db-a006-5f8d99a97aa2"));
                shoppingList.setName("Stephanie's birthday");

                mockMvc.perform(MockMvcRequestBuilders.post("/shopping-lists")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBodyJson))
                                .andExpect(MockMvcResultMatchers.status().isCreated())
                                .andExpect(MockMvcResultMatchers.header().string("Location",
                                                "http://localhost/shopping-lists/" + shoppingList.getShoppingListId()));

        }

        @Test
        public void testGet() throws Exception {

                String shoppingListId = "00611cca-2076-446b-89e8-0f53735a7a5a";

                String shoppingListJSON = Resources.toString(
                                Resources.getResource("shoppinglist/shoppinglist-get.json"),
                                Charsets.UTF_8);

                mockMvc.perform(MockMvcRequestBuilders.get("/shopping-lists/" + shoppingListId))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.content().json(shoppingListJSON));

        }

        @Test
        public void testGetAll() throws Exception {

                String shoppingListsJSON = Resources.toString(
                                Resources.getResource("shoppinglist/shoppinglist-get-all.json"),
                                Charsets.UTF_8);

                mockMvc.perform(MockMvcRequestBuilders.get("/shopping-lists"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.content().json(shoppingListsJSON));

        }

        @Test
        public void testAddCocktail() throws Exception {

                ShoppingListBodyAddCocktail requestBody = new ShoppingListBodyAddCocktail();
                requestBody.setCocktailId(UUID.fromString("c16acb4d-c85e-43db-a006-5f8d99a97aa2"));

                Gson requestBodyGson = new Gson();

                String requestBodyJson = requestBodyGson.toJson(requestBody);

                UUID shoppingListId = UUID.fromString("c16acb4d-c85e-43db-a006-5f8d99a97aa2");

                mockMvc.perform(MockMvcRequestBuilders.post("/shopping-lists/" + shoppingListId + "/cocktails")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBodyJson))
                                .andExpect(MockMvcResultMatchers.status().isCreated())
                                .andExpect(MockMvcResultMatchers.header().string("Location",
                                                "http://localhost/shopping-lists/" + shoppingListId + "/cocktails/"
                                                                + requestBody.getCocktailId()));

        }
}
