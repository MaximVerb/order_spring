package com.switchfully.order.spring_exercise.repositories.item;

import com.switchfully.order.spring_exercise.exceptions.EntityCouldNotBeFoundExc;
import com.switchfully.order.spring_exercise.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private final ConcurrentHashMap<String, Item> itemById;

    public ItemRepositoryImpl() {
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

    @Override
    public Item getItemByNameAndDescription(String name, String description) {
        return itemById.values()
                .stream()
                .filter(itemInDB -> itemInDB.getName().equals(name) && itemInDB.getDescription().equals(description))
                .findFirst()
                .orElseThrow(() ->  {throw new EntityCouldNotBeFoundExc(); });
    }

    @Override
    public Item getItemById(String id) {
        return itemById.get(id);
    }

    @Override
    public void updateItemById(String id, Item item) {
        itemById.computeIfPresent(id, (key, value) -> value = item);
    }
}
