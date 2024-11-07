package com.example.shopping_app_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shop;
    private String productName;
    private BigDecimal price;
    private int amount;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
