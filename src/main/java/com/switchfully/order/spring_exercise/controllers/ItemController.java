package com.switchfully.order.spring_exercise.controllers;

import com.switchfully.order.spring_exercise.services.item.CreateItemDto;
import com.switchfully.order.spring_exercise.services.item.ItemDto;
import com.switchfully.order.spring_exercise.services.item.ItemService;
import com.switchfully.order.spring_exercise.services.item.UpdatedItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    //TODO As an admin user I want to add an item so I can expand the list of available items.
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createdItemDto) {
        return itemService.createItem(createdItemDto);
    }

    //TODO As an admin I want to be able to update an item
    @PutMapping(consumes = APPLICATION_JSON_VALUE, path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItemById(@PathVariable ("id") String id,
                                  @RequestBody UpdatedItemDto updatedItemDto)
    {return itemService.updateItemById(id, updatedItemDto); }

}
