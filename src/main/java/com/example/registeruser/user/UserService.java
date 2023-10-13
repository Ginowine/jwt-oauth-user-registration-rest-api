package com.example.registeruser.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(Math.toIntExact(id));
               // finById(id);
                //getUserById(id);
        return optionalUser.get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(Math.toIntExact(user.getId())).get()
;                //finById(user.getId()).get();
                //getUserById(user.getId()).get();
        //User existingUser = userRepository.findById(Math.toIntExact(user.getId())).get();

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(Math.toIntExact(userId));
    }
}
