package com.DemoShop.Services;

import com.DemoShop.Models.User;
import com.DemoShop.Repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public ResponseEntity<User> registerUser(User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
    }

    public ResponseEntity<User> loginUser(User user) {
        User foundUser = userRepo.findByEmail(user.getEmail());
        if (!foundUser.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        }
    }

    public ResponseEntity<User> updateUser(User user, long id) {
        if (userRepo.existsById(id)) {
            User updatedUser = userRepo.findById(id).get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            return new ResponseEntity<>(userRepo.save(updatedUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<?>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> geUserById(long id) {
        if (userRepo.existsById(id)) {
            return  new ResponseEntity<>(userRepo.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
