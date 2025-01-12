package com.example.shopping_app_backend.controller;

import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ItemToUpdate;
import com.example.shopping_app_backend.dto.GetItem;
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
@CrossOrigin(origins="*", allowedHeaders = "*")
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
    public ResponseEntity<List<GetItem>> getAllUserItems(@PathVariable long userId) {
        List<GetItem> items = itemService.getAllUserItems(userId);
        return ResponseEntity.ok(items);
    }

    @Operation(summary = "Aktualizacja produktu")
    @PutMapping
    public ResponseEntity<Void> updateItem(@RequestBody ItemToUpdate itemToUpdate) {
        itemService.updateItem(itemToUpdate);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Zakup produktu")
    @PutMapping("buy/{id}")
    public ResponseEntity<Void> buyItem(@PathVariable long id) {
        itemService.buyItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("Test success");
    }
}
