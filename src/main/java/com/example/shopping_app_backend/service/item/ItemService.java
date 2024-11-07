package com.example.shopping_app_backend.service.item;

import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ProductToUpdate;
import com.example.shopping_app_backend.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void add(NewItem newItem);
    void deleteItem(long id);
    List<Item> getAllUserItems(long userId);
    void updateItem(ProductToUpdate productToUpdate);
}
