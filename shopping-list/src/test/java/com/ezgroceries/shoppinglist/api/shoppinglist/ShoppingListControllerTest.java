package com.ezgroceries.shoppinglist.api.shoppinglist;

import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ezgroceries.shoppinglist.api.shoppinglist.body.ShoppingListBodyCreate;
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

                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setName("Stephanie's birthday");
                shoppingList.setShoppingListId(UUID.fromString(shoppingListId));
                shoppingList.setIngredients(new String[] {
                                "Tequila",
                                "Triple sec",
                                "Lime juice",
                                "Salt",
                                "Blue Curacao"
                });

                Gson requestBodyGson = new Gson();
                String shoppingListJson = requestBodyGson.toJson(shoppingList);

                mockMvc.perform(MockMvcRequestBuilders.get("/shopping-lists/" + shoppingListId))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.content().json(shoppingListJson));

        }

        @Test
        public void testGetAll() throws Exception {

                int expectedSize = 2;

                mockMvc.perform(MockMvcRequestBuilders.get("/shopping-lists"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.name empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.shoppingListId empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.ingredients empty false)]",
                                                                Matchers.hasSize(expectedSize)));

        }
}
