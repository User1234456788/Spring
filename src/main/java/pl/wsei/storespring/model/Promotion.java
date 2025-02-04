package pl.wsei.storespring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "promotionName")
    private String name;

    @Column(name = "promotionDescryption")
    private String descryption;

    @Column(name = "promotionPercentage")
    @Min(value = 0, message = "promotion must be at least 0")
    @Max(value = 100, message = "promotion must not exceed 100")
    private int promotion;

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

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
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
