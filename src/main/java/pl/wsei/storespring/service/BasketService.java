package pl.wsei.storespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsei.storespring.dto.BasketDTO;
import pl.wsei.storespring.exception.ResourceNotFoundException;
import pl.wsei.storespring.model.Basket;
import pl.wsei.storespring.repository.BasketRepository;

import java.util.List;

@Service
public class BasketService {

	private BasketRepository basketRepository;

	@Autowired
	public BasketService(BasketRepository basketRepository) {
		this.basketRepository = basketRepository;
	}

	public Basket createBasket(BasketDTO basketDto) {
		Basket basket = BasketDTO.toEntity(basketDto);
		return basketRepository.save(basket);
	}

	public BasketDTO getBasketById(Long id) {
		return BasketDTO.fromEntity(basketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found")));
	}

	public List<BasketDTO> getAllBaskets() {
		return basketRepository.findAll().stream().map(BasketDTO::fromEntity).toList();
	}

	public Basket updateBasket(Long id, BasketDTO basketDetails) {
		Basket basket = basketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
		basket.setItems(basketDetails.getItem());
		return basketRepository.save(basket);
	}

	public void deleteBasket(Long id) {
		Basket basket = basketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Basket not found"));
		basketRepository.delete(basket);
	}
}