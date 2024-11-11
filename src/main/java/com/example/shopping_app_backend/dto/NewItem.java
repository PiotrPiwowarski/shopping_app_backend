package com.example.shopping_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewItem {

    private String shop;
    private String productName;
    private String price;
    private String amount;
    private String description;
    private String imageUrl;
    private long userId;
}
