package com.switchfully.order.spring_exercise.services.item;

import java.util.List;

public interface ItemService {
    ItemDto createItem(CreateItemDto createdItemDto);
    ItemDto updateItemById(Long id, UpdatedItemDto updatedItemDto);
    List<ItemDto> getAllItems();
}
