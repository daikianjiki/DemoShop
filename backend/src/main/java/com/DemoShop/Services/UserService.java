package com.DemoShop.Services;

import com.DemoShop.Models.User;
import com.DemoShop.Repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public ResponseEntity<User> registerUser(User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
    }

    public ResponseEntity<User> loginUser(User user) {
        User foundUser = userRepo.findByUsername(user.getUsername());
        if (!foundUser.getPassword().equals(user.getPassword())) {
            return null;
        } else {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        }
    }
}
