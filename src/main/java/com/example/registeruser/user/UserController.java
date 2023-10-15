package com.example.registeruser.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User")

public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // GET http://localhost:8080/api/v1/users/1

    @Operation (
            description = "Get endpoint for user",
            summary = "This is a summary for Usert get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )

    @GetMapping(value = "/{id}")
    @RolesAllowed({ "USER", "ADMIN"})
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userServiceImpl.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // GET http://localhost:8080/api/v1/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // PUT http://localhost:8080/api/v1/users/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser = userServiceImpl.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // DELETE http://localhost:8080/api/v1/users/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userServiceImpl.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    // PATCH http://localhost:8080/api/v1/users
    @PostMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ){
        userServiceImpl.changePassword(request, connectedUser);
        return ResponseEntity.accepted().build();
    }
}
