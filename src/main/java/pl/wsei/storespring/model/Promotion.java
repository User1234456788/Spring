package pl.wsei.storespring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "promotionPercentage")
    @Min(value = 0, message = "promotion must be at least 0")
    @Max(value = 100, message = "promotion must not exceed 100")
    private int promotion;

    private boolean isActive;

    private List<Item> promotedItems;

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

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Item> getPromotedItems() {
        return promotedItems;
    }

    public void setPromotedItems(List<Item> promotedItems) {
        this.promotedItems = promotedItems;
    }
}
