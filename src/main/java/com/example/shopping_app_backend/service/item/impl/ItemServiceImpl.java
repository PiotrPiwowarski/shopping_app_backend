package com.example.shopping_app_backend.service.item.impl;

import com.example.shopping_app_backend.dto.GetItem;
import com.example.shopping_app_backend.dto.NewItem;
import com.example.shopping_app_backend.dto.ItemToUpdate;
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
        User user = userRepository.findById(newItem.getUserId()).orElseThrow(NoUsersWithSuchIdException::new);
        Item item = ItemMapper.map(newItem, user);
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
        itemRepository.delete(item);
    }

    @Override
    public List<GetItem> getAllUserItems(long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoUsersWithSuchIdException::new);
        return itemRepository.findAllByUser(user).stream().map(ItemMapper::map).toList();
    }

    @Transactional
    @Override
    public void updateItem(ItemToUpdate itemToUpdate) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Item item = itemRepository.findById(itemToUpdate.getId()).orElseThrow(NoItemsWithSuchIdException::new);
        User user = userRepository.findById(item.getUser().getId()).orElseThrow(NoUsersWithSuchIdException::new);
        if(!userName.equals(user.getEmail())) {
            throw new UnauthorizedActionException();
        }
        item.setShop(itemToUpdate.getShop());
        item.setProductName(itemToUpdate.getProductName());
        item.setPrice(itemToUpdate.getPrice());
        item.setAmount(itemToUpdate.getAmount());
        item.setDescription(itemToUpdate.getDescription());
        item.setImageUrl(itemToUpdate.getImageUrl());
        item.setBought(itemToUpdate.isBought());
    }

    @Transactional
    @Override
    public void buyItem(long id) {
        Item item = itemRepository.findById(id).orElseThrow(NoItemsWithSuchIdException::new);
        boolean isBought = !item.isBought();
        item.setBought(isBought);
        itemRepository.save(item);
    }
}
