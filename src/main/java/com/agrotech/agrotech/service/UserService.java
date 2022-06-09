package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.User;
import com.agrotech.agrotech.domain.repository.IUserRepository;
import com.agrotech.agrotech.domain.service.IUserService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User>getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id",userId));
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password).orElseThrow(
                () -> new ResourceNotFoundException("User","Email",email));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return userRepository.save(user
                .setName(userRequest.getName())
                .setLastname(userRequest.getLastname())
                .setDni(userRequest.getDni())
                .setCellphoneNumber(userRequest.getCellphoneNumber())
                .setEmail(userRequest.getEmail())
                .setPassword(userRequest.getPassword())
                .setProfileImage(userRequest.getProfileImage())
        );
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
