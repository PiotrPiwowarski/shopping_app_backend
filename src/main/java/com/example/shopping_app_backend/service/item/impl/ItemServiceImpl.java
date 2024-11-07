package com.example.shopping_app_backend.service.item.impl;

import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ProductToUpdate;
import com.example.shopping_app_backend.entity.Item;
import com.example.shopping_app_backend.entity.User;
import com.example.shopping_app_backend.exceptions.NoItemsWithSuchIdException;
import com.example.shopping_app_backend.exceptions.NoUsersWithSuchIdException;
import com.example.shopping_app_backend.exceptions.UnauthorizedActionException;
import com.example.shopping_app_backend.mapper.ItemMapper;
import com.example.shopping_app_backend.repository.ItemRepository;
import com.example.shopping_app_backend.repository.UserRepository;
import com.example.shopping_app_backend.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    public void add(NewItem newItem) {
        Item item = ItemMapper.map(newItem);
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(long id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Item item = itemRepository.findById(id).orElseThrow(NoItemsWithSuchIdException::new);
        User user = userRepository.findById(item.getUser().getId()).orElseThrow(NoUsersWithSuchIdException::new);
        if(!userName.equals(user.getEmail())) {
            throw new UnauthorizedActionException();
        }
        userRepository.delete(user);
    }

    @Override
    public List<Item> getAllUserItems(long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoUsersWithSuchIdException::new);
        return itemRepository.findAllByUser(user);
    }

    @Transactional
    @Override
    public void updateItem(ProductToUpdate productToUpdate) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Item item = itemRepository.findById(productToUpdate.getId()).orElseThrow(NoItemsWithSuchIdException::new);
        User user = userRepository.findById(item.getUser().getId()).orElseThrow(NoUsersWithSuchIdException::new);
        if(!userName.equals(user.getEmail())) {
            throw new UnauthorizedActionException();
        }
        item.setShop(productToUpdate.getShop());
        item.setProductName(productToUpdate.getProductName());
        item.setPrice(productToUpdate.getPrice());
        item.setAmount(productToUpdate.getAmount());
        item.setDescription(productToUpdate.getDescription());
        item.setImageUrl(productToUpdate.getImageUrl());
    }
}
