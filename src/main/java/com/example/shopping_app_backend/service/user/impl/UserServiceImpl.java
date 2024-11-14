package com.example.shopping_app_backend.service.user.impl;

import com.example.shopping_app_backend.dto.Authentication;
import com.example.shopping_app_backend.dto.EmailAndPassword;
import com.example.shopping_app_backend.dto.GetUser;
import com.example.shopping_app_backend.dto.NewUser;
import com.example.shopping_app_backend.entity.Token;
import com.example.shopping_app_backend.entity.User;
import com.example.shopping_app_backend.exceptions.NoUsersWithSuchIdException;
import com.example.shopping_app_backend.exceptions.UnauthorizedActionException;
import com.example.shopping_app_backend.exceptions.UserWithSuchEmailAlreadyExists;
import com.example.shopping_app_backend.mapper.UserMapper;
import com.example.shopping_app_backend.repository.TokenRepository;
import com.example.shopping_app_backend.repository.UserRepository;
import com.example.shopping_app_backend.service.jwt.JwtService;
import com.example.shopping_app_backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;


    @Override
    public void addNewUser(NewUser newUser) {
        Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserWithSuchEmailAlreadyExists();
        }
        User user = UserMapper.map(newUser, passwordEncoder);
        userRepository.save(user);
    }

    @Override
    public GetUser getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(NoUsersWithSuchIdException::new);
        return UserMapper.map(user);
    }

    @Override
    public Authentication login(EmailAndPassword emailAndPassword) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        emailAndPassword.getEmail(),
                        emailAndPassword.getPassword()
                )
        );
        User user = userRepository
                .findByEmail(emailAndPassword.getEmail())
                .orElseThrow(NoUsersWithSuchIdException::new);
        String jwtToken = jwtService.generateToken(user);
        tokenRepository.deleteAllByUser(user);
        saveUserToken(jwtToken, user);
        return Authentication.builder()
                .token(jwtToken)
                .userId(user.getId())
                .build();
    }

    @Override
    public void deleteUser(long id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findById(id).orElseThrow(NoUsersWithSuchIdException::new);
        if(!name.equals(user.getEmail())) {
            throw new UnauthorizedActionException();
        }
        userRepository.delete(user);
    }

    private void saveUserToken(String jwtToken, User user) {
        Token token = Token.builder()
                .token(jwtToken)
                .user(user)
                .build();
        tokenRepository.save(token);
    }
}
