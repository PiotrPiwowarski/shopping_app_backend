package com.example.shopping_app_backend.repository;

import com.example.shopping_app_backend.entity.Token;
import com.example.shopping_app_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);
    @Modifying
    @Transactional
    void deleteAllByUser(User user);
}
