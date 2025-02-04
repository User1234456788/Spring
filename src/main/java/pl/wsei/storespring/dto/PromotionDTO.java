package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.Item;
import pl.wsei.storespring.model.Promotion;

import java.util.List;

public class PromotionDTO {

    private long id;

    private int promotion;

    private boolean isActive;

    private List<Item> promotedItems;



    public static PromotionDTO fromEntity(Promotion promotion) {
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.id = promotion.getId();
        promotionDTO.promotion = promotion.getPromotion();
        promotionDTO.isActive = promotion.getActive();
        promotionDTO.promotedItems = promotion.getPromotedItems();
        return promotionDTO;
    }

    public static Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        promotion.setId(promotionDTO.id);
        promotion.setPromotion(promotionDTO.promotion);
        promotion.setActive(promotion.getActive());
        promotion.setPromotedItems(promotion.getPromotedItems());
        return promotion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public List<Item> getPromotedItems() {
        return promotedItems;
    }

    public void setPromotedItems(List<Item> promotedItems) {
        this.promotedItems = promotedItems;
    }
}
