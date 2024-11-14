package com.example.shopping_app_backend.mapper;

import com.example.shopping_app_backend.dto.GetItem;
import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.entity.Item;
import com.example.shopping_app_backend.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static Item map(NewItem newItem, User user) {
        return Item.builder()
                .shop(newItem.getShop())
                .productName(newItem.getProductName())
                .price(new BigDecimal(newItem.getPrice()))
                .amount(new BigDecimal(newItem.getAmount()))
                .description(newItem.getDescription())
                .imageUrl(newItem.getImageUrl())
                .user(user)
                .build();
    }

    public static GetItem map(Item item) {
        return GetItem.builder()
                .id(item.getId())
                .shop(item.getShop())
                .productName(item.getProductName())
                .price(item.getPrice())
                .amount(item.getAmount())
                .description(item.getDescription())
                .imageUrl(item.getImageUrl())
                .userId(item.getUser().getId())
                .build();
    }
}
