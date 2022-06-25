package com.project.questapp.Services;

import com.project.questapp.Entities.User;
import com.project.questapp.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUSer(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUseer = user.get();
            foundUseer.setUsername(newUser.getUsername());
            foundUseer.setPassword(newUser.getPassword());
            userRepository.save(foundUseer);
            return foundUseer;
        } else {
            return null;
        }
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
