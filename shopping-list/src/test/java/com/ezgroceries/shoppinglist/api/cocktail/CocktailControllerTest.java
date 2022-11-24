package com.ezgroceries.shoppinglist.api.cocktail;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CocktailController.class)
@Import(CocktailControllerTestConfiguration.class)
public class CocktailControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testSearch() throws Exception {

                int expectedSize = 2;

                mockMvc.perform(MockMvcRequestBuilders.get("/cocktails").param("search", "Russian"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.name empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.cocktailId empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.glass empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.instructions empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.image empty false)]",
                                                                Matchers.hasSize(expectedSize)))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$[?(@.ingredients empty false)]",
                                                                Matchers.hasSize(expectedSize)));
        }
}
