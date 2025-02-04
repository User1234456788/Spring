package pl.wsei.storespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsei.storespring.dto.PromotionDTO;
import pl.wsei.storespring.exception.ResourceNotFoundException;
import pl.wsei.storespring.model.Promotion;
import pl.wsei.storespring.repository.PromotionRepository;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion createPromotion(PromotionDTO promotionDTO) {
        Promotion promo = PromotionDTO.toEntity(promotionDTO);
        return promotionRepository.save(promo);
    }

    public PromotionDTO getPromotionById(Long id) {
        return PromotionDTO.fromEntity(promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion not found")));
    }

    public Promotion updatePromotion(Long id, PromotionDTO promodatails) {
        Promotion promo = promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion not found"));
        promo.setPromotion(promodatails.getPromotion());
        return promotionRepository.save(promo);
    }

    public void deletePromotion(Long id) {
        Promotion promo = promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion not found"));
        promotionRepository.delete(promo);
    }

    public void activatePromotion(Long id){
        Promotion promo = promotionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion not found"));
        promo.setActive(true);
    }

}
