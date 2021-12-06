package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item convertDtoToItem(CreateItemDto createdItemDto) {
        return new Item.Builder(
                createdItemDto.getName(),
                createdItemDto.getDescription(),
                createdItemDto.getPrice())
                .withStock(createdItemDto.getStock())
                .build();
    }
}
