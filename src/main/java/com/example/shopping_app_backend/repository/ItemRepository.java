package com.example.shopping_app_backend.repository;

import com.example.shopping_app_backend.entity.Item;
import com.example.shopping_app_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByUser(User user);
    void deleteAllByUser(User user);
}
