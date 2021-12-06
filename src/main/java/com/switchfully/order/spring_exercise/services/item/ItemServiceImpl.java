package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.repositories.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto createItem(CreateItemDto createdItemDto) {
        Item item = itemMapper.convertDtoToItem(createdItemDto);
        itemRepository.save(item);
        return new ItemDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.getAllItems()
                .stream()
                .map(ItemDto::new)
                .collect(Collectors.toList());
    }
}
