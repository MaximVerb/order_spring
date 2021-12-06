package com.switchfully.order.spring_exercise.repositories.item;

import com.switchfully.order.spring_exercise.custom.ItemCouldNotBeFoundExc;
import com.switchfully.order.spring_exercise.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    void save(Item item);

    List<Item> getAllItems();
    Item getItem(Item item) throws ItemCouldNotBeFoundExc;
}
