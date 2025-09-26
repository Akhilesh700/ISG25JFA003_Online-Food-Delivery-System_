package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.security.AuthUtil;
import com.cognizant.onlinefooddeliverysystem.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import static org.mockito.Mockito.when;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuController.class)
public class MenuControllerTest {

    private static final String API_BASE_PATH = "/api/v1/menu";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private AuthUtil authUtil;

    @MockitoBean
    private UserRepository userRepository;

    // Use Mockito to isolate the controller logic from the database
    @MockitoBean
    private MenuService service;

    private MenuItems menuItem1;
    private CreateMenuItemRequestDto createMenuItemRequestDto;
    private CreateMenuItemResponseDto createMenuItemResponseDto;

    @BeforeEach
    void setUp() {
        menuItem1 = new MenuItems();
        menuItem1.setName("Pepperoni Pizza");
        menuItem1.setPrice(new BigDecimal("15.99"));

        createMenuItemRequestDto = new CreateMenuItemRequestDto();
        createMenuItemRequestDto.setName("Cheese Burger");
        createMenuItemRequestDto.setDescription("A delicious beef patty with cheddar cheese");
        createMenuItemRequestDto.setPrice(new BigDecimal("9.99"));
        createMenuItemRequestDto.setIsAvailable(true);
        createMenuItemRequestDto.setIsVegetarian(false);
        createMenuItemRequestDto.setCuisineType("American");
        createMenuItemRequestDto.setPrepTime(15);
    }

    //------------------------------------------
    // Tests for getAllMenu()
    //------------------------------------------
    @Test
    @WithMockUser(roles = {"ADMIN", "CUSTOMER"})
    void testGetAllMenu_Success() throws Exception {
        when(service.getAllMenu()).thenReturn(Collections.singletonList(menuItem1));

        mockMvc.perform(get(API_BASE_PATH)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Pepperoni Pizza"));
    }

    //------------------------------------------
    // Tests for addMenuItemByRestaurantId()
    //------------------------------------------
    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testAddMenuItemByRestaurantId_Success() throws Exception {
        Integer restId = 1;
        createMenuItemResponseDto = new CreateMenuItemResponseDto(restId, 1, createMenuItemRequestDto.getName());
        when(service.addMenuItem(restId, createMenuItemRequestDto)).thenReturn(createMenuItemResponseDto);

        mockMvc.perform(post(API_BASE_PATH + "/{restID}", restId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createMenuItemRequestDto))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.restId").value(restId))
                .andExpect(jsonPath("$.name").value(createMenuItemRequestDto.getName()));

    }

    //------------------------------------------
    // Tests for getAllMenuItemsByRestaurantID()
    //------------------------------------------
    @Test
    @WithMockUser(roles = {"ADMIN", "CUSTOMER"})
    void testGetAllMenuItemsByRestaurantID_Success() throws Exception {
        Integer restId = 1;
        when(service.getAllMenuByRestaurantID(restId)).thenReturn(Collections.singletonList(menuItem1));

        mockMvc.perform(get(API_BASE_PATH + "/{restID}", restId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}