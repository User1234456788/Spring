package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.Item;

public class ItemDTO {

    long id;

    String name;
    String quantity;

    public static ItemDTO fromEntity(Item item) {
        ItemDTO itemdto = new ItemDTO();
        itemdto.id = item.getId();
        itemdto.name = item.getName();
        itemdto.quantity = item.getQuantity();
        return itemdto;
    }

    public static Item toEntity(ItemDTO itemdto) {
        Item item = new Item();
        item.setId(itemdto.id);
        item.setName(itemdto.name);
        item.setQuantity(itemdto.quantity);
        return item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
