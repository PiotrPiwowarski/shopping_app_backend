package com.example.shopping_app_backend.mapper;

import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.entity.Item;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static Item map(NewItem newItem) {
        return Item.builder()
                .shop(newItem.getShop())
                .productName(newItem.getProductName())
                .price(newItem.getPrice())
                .amount(newItem.getAmount())
                .description(newItem.getDescription())
                .imageUrl(newItem.getImageUrl())
                .build();
    }
}
