package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item convertDtoToItem(CreateItemDto createdItemDto) {
        return Item.builder()
                .name(createdItemDto.getName())
                .description(createdItemDto.getDescription())
                .price(createdItemDto.getPrice())
                .warehouse(createdItemDto.getWarehouse())
                .build();
    }

    public Item convertUpdatedDtoToItem(UpdatedItemDto updatedItemDto) {
        return Item.builder()
                .name(updatedItemDto.getName())
                .description(updatedItemDto.getDescription())
                .price(updatedItemDto.getPrice())
                .warehouse(updatedItemDto.getWarehouse())
                .build();
    }
}
