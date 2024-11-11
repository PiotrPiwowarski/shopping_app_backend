package com.example.shopping_app_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductToUpdate {

    private long id;
    private String shop;
    private String productName;
    private BigDecimal price;
    private BigDecimal amount;
    private String description;
    private String imageUrl;
}
