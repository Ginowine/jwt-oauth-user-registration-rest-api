package com.example.registeruser.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email);

    //Optional<User> getUserById(Long userId);


    //Optional<User> findById(Long userId);

    //Optional<User> updateUser(User user);

    //Optional<User> deleteUser(Long userId);

    //Optional<User> finById(Long userId);
}
