package pl.wsei.storespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsei.storespring.dto.ItemDTO;
import pl.wsei.storespring.exception.ResourceNotFoundException;
import pl.wsei.storespring.model.Item;
import pl.wsei.storespring.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(ItemDTO itemDto) {
        Item item = ItemDTO.toEntity(itemDto);
        return itemRepository.save(item);
    }

    public ItemDTO getItemById(Long id) {
        return ItemDTO.fromEntity(itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(ItemDTO::fromEntity).toList();
    }

    public Item updateItem(Long id, ItemDTO itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        item.setName(itemDetails.getName());
        item.setQuantity(itemDetails.getQuantity());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        itemRepository.delete(item);
    }
}