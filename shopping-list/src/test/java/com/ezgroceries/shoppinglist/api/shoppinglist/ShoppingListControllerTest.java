package com.ezgroceries.shoppinglist.api.shoppinglist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.mockito.BDDMockito;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@WebMvcTest(ShoppingListController.class)
public class ShoppingListControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ShoppingListService shoppingListService;

        @Test
        public void testCreate() throws Exception {

                ShoppingListCreateRequestBody requestBody = new ShoppingListCreateRequestBody();
                requestBody.setName("Stephanie's birthday");

                Gson requestBodyGson = new Gson();
                String requestBodyJson = requestBodyGson.toJson(requestBody);

                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setShoppingListId(UUID.randomUUID());
                shoppingList.setName("Stephanie's birthday");

                BDDMockito.given(shoppingListService.create(BDDMockito.any(ShoppingListCreateRequestBody.class)))
                                .willReturn(shoppingList);

                mockMvc.perform(MockMvcRequestBuilders.post("/shopping-lists")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBodyJson))
                                .andExpect(MockMvcResultMatchers.status().isCreated())
                                .andExpect(MockMvcResultMatchers.header().string("Location",
                                                "http://localhost/shopping-lists/" + shoppingList.getShoppingListId()));

        }

        @Test
        public void testGet() {

        }

        @Test
        public void testGetAll() {

        }
}
