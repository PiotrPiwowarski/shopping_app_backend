package com.example.shopping_app_backend.controller;

import com.example.shopping_app_backend.dto.Authentication;
import com.example.shopping_app_backend.dto.EmailAndPassword;
import com.example.shopping_app_backend.dto.GetUser;
import com.example.shopping_app_backend.dto.NewUser;
import com.example.shopping_app_backend.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "Users API")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Dodanie nowego użytkownika")
    @PostMapping("/register")
    public ResponseEntity<Void> addUser(@RequestBody NewUser newUser) {
        userService.addNewUser(newUser);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pobranie użytkownika po id")
    @GetMapping("/{id}")
    public ResponseEntity<GetUser> getUser(@PathVariable long id) {
        GetUser user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Usunięcie użytkownika po id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Zalogowanie")
    @PostMapping("/login")
    public ResponseEntity<Authentication> login(@RequestBody EmailAndPassword emailAndPassword) {
        Authentication authentication = userService.login(emailAndPassword);
        return ResponseEntity.ok(authentication);
    }

    @Operation(summary = "Wylogowanie")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }
}
