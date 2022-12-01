package com.ezgroceries.shoppinglist.api.cocktail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@WebMvcTest(CocktailController.class)
@Import(CocktailControllerTestConfiguration.class)
public class CocktailControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testSearch() throws Exception {

                String shoppingListsJSON = Resources.toString(Resources.getResource("cocktail/cocktail-search.json"),
                                Charsets.UTF_8);

                mockMvc.perform(MockMvcRequestBuilders.get("/cocktails").param("search", "Russian"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.content().json(shoppingListsJSON));

        }
}
