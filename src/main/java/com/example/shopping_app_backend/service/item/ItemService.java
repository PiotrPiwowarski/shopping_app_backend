package com.example.shopping_app_backend.service.item;

import com.example.shopping_app_backend.dto.GetItem;
import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ItemToUpdate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void add(NewItem newItem);
    void deleteItem(long id);
    List<GetItem> getAllUserItems(long userId);
    void updateItem(ItemToUpdate itemToUpdate);
    void buyItem(long id);
}
