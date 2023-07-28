package com.DemoShop.Controllers;

import com.DemoShop.Models.User;
import com.DemoShop.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<User> registerUser(User user) {
        return userService.registerUser(user);
    }

}
