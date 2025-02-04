package pl.wsei.storespring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import pl.wsei.storespring.model.Promotion;


public class PromotionDTO {

    private long id;

    private String descryption;

    private String name;

    @Column(name = "promotionPercentage")
    @Min(value = 0, message = "promotion must be at least 0")
    @Max(value = 100, message = "promotion must not exceed 100")
    private int promotion;


    public static PromotionDTO fromEntity(Promotion promotion) {
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.id = promotion.getId();
        promotionDTO.promotion = promotion.getPromotion();
        promotionDTO.descryption = promotion.getDescryption();
        promotionDTO.name = promotion.getName();
        return promotionDTO;
    }

    public static Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        promotion.setId(promotionDTO.id);
        promotion.setPromotion(promotionDTO.promotion);
        promotion.setName(promotionDTO.getName());
        promotion.setDescryption(promotionDTO.getDescryption());
        return promotion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 0, message = "promotion must be at least 0")
    @Max(value = 100, message = "promotion must not exceed 100")
    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(@Min(value = 0, message = "promotion must be at least 0") @Max(value = 100, message = "promotion must not exceed 100") int promotion) {
        this.promotion = promotion;
    }
}
