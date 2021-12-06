package com.switchfully.order.spring_exercise.repositories.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.services.item.ItemDto;
import com.switchfully.order.spring_exercise.services.item.ItemMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private final ConcurrentHashMap<String, Item> itemById;
    private final ItemMapper itemMapper;

    public ItemRepositoryImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
        itemById = new ConcurrentHashMap<>();
    }

    @Override
    public void save(Item item) {
        itemById.put(item.getId(), item);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(itemById.values());
    }
}
