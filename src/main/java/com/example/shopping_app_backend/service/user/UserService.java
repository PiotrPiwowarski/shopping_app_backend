package com.example.shopping_app_backend.service.user;

import com.example.shopping_app_backend.dto.Authentication;
import com.example.shopping_app_backend.dto.EmailAndPassword;
import com.example.shopping_app_backend.dto.GetUser;
import com.example.shopping_app_backend.dto.NewUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void addNewUser(NewUser newUser);
    GetUser getUser(long id);
    Authentication login(EmailAndPassword emailAndPassword);
    void deleteUser(long id);

}
