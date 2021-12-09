package com.switchfully.order.spring_exercise.controllers;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.repositories.item.ItemRepository;
import com.switchfully.order.spring_exercise.repositories.item.ItemRepositoryImpl;
import com.switchfully.order.spring_exercise.services.item.CreateItemDto;
import com.switchfully.order.spring_exercise.services.item.ItemDto;
import com.switchfully.order.spring_exercise.services.item.ItemMapper;
import com.switchfully.order.spring_exercise.services.item.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;

class ItemServiceTest {
    private ItemService itemService;
    private ItemMapper itemMapper;
    private Item itemActual;
    private Item expectedItem;
    private CreateItemDto createdItemDto;

    @BeforeEach
    void setup() {
        itemMapper = mock(ItemMapper.class); //gwn instantieren want maakt geen externe calls
        itemService = mock(ItemService.class);

        expectedItem = new Item.Builder("bike", "a decathlon bike", new BigDecimal("10.00"))
                .withStock(10L)
                .build();

        itemActual = new Item.Builder("bike", "a decathlon bike", new BigDecimal("10.00"))
                .withStock(10L)
                .build();

        createdItemDto = new CreateItemDto.Builder(expectedItem.getName(), expectedItem.getDescription(),
                expectedItem.getPrice(), expectedItem.getStock())
                .build();
    }

    @Test
    void whenServiceAddsItem_whenRunMethod_thenItemDtoReturned() {
        ItemDto expectedItemDto = new ItemDto(expectedItem);
        ItemDto actualItemDto = new ItemDto(itemActual);

        Mockito.when(itemService.createItem(createdItemDto)).thenReturn(expectedItemDto);

        Assertions.assertEquals(expectedItemDto, actualItemDto);
    }


}