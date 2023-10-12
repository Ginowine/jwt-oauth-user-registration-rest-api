package com.example.registeruser.auth;

import com.example.registeruser.user.User;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        // implement later
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
        // implement later
        return ResponseEntity.ok(service.authenticate(request));
    }

//    @PutMapping("/users/{email}")
//    public ResponseEntity<AuthenticationResponse> updateUser(@PathVariable String email, @RequestBody User updatedAttributes, AuthenticationRequest request) {
//        AuthenticationResponse response = service.updateUser(email, updatedAttributes);
//        if (response != null) {
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Go back and implemnt update and delete service the way it was
    // implemented in your 2 year JTW Udacity github way, where other controllers don't have to care about
    // authentication, just do your normal stuff in the controller, and put the url
}