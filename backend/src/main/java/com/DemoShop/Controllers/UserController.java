package com.DemoShop.Controllers;

import com.DemoShop.Models.User;
import com.DemoShop.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {
        return userService.updateUser(user, id);
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.geUserById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
