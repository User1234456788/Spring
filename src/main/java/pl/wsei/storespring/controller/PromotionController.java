package pl.wsei.storespring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsei.storespring.dto.ItemDTO;
import pl.wsei.storespring.dto.PromotionDTO;
import pl.wsei.storespring.model.Item;
import pl.wsei.storespring.model.Promotion;
import pl.wsei.storespring.service.ItemService;
import pl.wsei.storespring.service.PromotionService;

@Tag(name = "Promotion", description = "promotion management APIs")
@RestController
@RequestMapping("/api")
public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Operation(summary = "Get Promotion by ID")
    @GetMapping("/promotion/{id}")
    public ResponseEntity<PromotionDTO> getPromotionById(@PathVariable Long id) {
        PromotionDTO promotion = promotionService.getPromotionById(id);
        return ResponseEntity.ok(promotion);
    }

    @Operation(summary = "Create a new promotion")
    @PostMapping("/promotion")
    public ResponseEntity<Promotion> createPromotion(@RequestBody PromotionDTO promotion) {
        Promotion createdPromotion = promotionService.createPromotion(promotion);
        return ResponseEntity.status(201).body(createdPromotion);
    }

    @Operation(summary = "Update an existing promotion")
    @PutMapping("/promotion/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody PromotionDTO promotion) {
        Promotion updatePromotion = promotionService.updatePromotion(id, promotion);
        return ResponseEntity.ok(updatePromotion);
    }

    @Operation(summary = "Delete a promotion")
    @DeleteMapping("/promotion/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
        return ResponseEntity.noContent().build();
    }
}
