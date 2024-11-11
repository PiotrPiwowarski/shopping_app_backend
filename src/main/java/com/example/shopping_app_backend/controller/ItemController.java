package com.example.shopping_app_backend.controller;

import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ProductToUpdate;
import com.example.shopping_app_backend.entity.Item;
import com.example.shopping_app_backend.service.item.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
@Tag(name = "Items API")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "Dodanie nowego produktu")
    @PostMapping
    public ResponseEntity<Void> addItem(@RequestBody NewItem newItem) {
        itemService.add(newItem);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Usunięcie produktu")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pobranie listy produktów użytkownika")
    @GetMapping("/{userId}")
    public ResponseEntity<List<Item>> getAllUserItems(@PathVariable long userId) {
        List<Item> items = itemService.getAllUserItems(userId);
        return ResponseEntity.ok(items);
    }

    @Operation(summary = "Aktualizacja produktu")
    @PutMapping
    public ResponseEntity<Void> updateItem(@RequestBody ProductToUpdate productToUpdate) {
        itemService.updateItem(productToUpdate);
        return ResponseEntity.ok().build();
    }
}
