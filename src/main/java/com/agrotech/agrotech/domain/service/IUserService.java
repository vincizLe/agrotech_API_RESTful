package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User getUserByEmailAndPassword(String email, String password);
    User createUser(User user);
    User updateUser(Long userId,User userRequest);
    ResponseEntity<?>deleteUser(Long userId);
}
