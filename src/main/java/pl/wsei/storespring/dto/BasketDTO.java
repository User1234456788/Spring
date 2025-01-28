package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.Basket;
import pl.wsei.storespring.model.Item;

import java.util.List;

public class BasketDTO {
	
	long id;
	
	private List<Item> items;

	public static BasketDTO fromEntity(Basket basket) {
		BasketDTO basketDTO = new BasketDTO();
		basketDTO.id = basket.getId();
		basketDTO.items = basket.getItems();
		return basketDTO;
	}

	public static Basket toEntity(BasketDTO basketDTO) {
		Basket basket = new Basket();
		basket.setId(basketDTO.id);
		basket.setItems(basketDTO.items);
		return basket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItem() {
		return items;
	}

	public void setItem(List<Item> items) {
		this.items = items;
	}
}
