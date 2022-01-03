package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.fromString;

@Service
@Transactional
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
    public ItemDto updateItemById(Long id, UpdatedItemDto updatedItemDto) {
        Item item = itemRepository.getById(id);
        itemRepository.save(item);
        return new ItemDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::new)
                .collect(Collectors.toList());
    }
}
