package com.example.registeruser.user;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/auth/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // http://localhost:8080/api/v1/auth/users/1
    @GetMapping(value = "/{id}")
    @RolesAllowed({ "USER", "ADMIN"})
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userServiceImpl.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/auth/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/auth/users/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser = userServiceImpl.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/auth/users/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userServiceImpl.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
