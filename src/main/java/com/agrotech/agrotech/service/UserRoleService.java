package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.UserRole;
import com.agrotech.agrotech.domain.repository.IRoleRepository;
import com.agrotech.agrotech.domain.repository.IUserRepository;
import com.agrotech.agrotech.domain.repository.IUserRoleRepository;
import com.agrotech.agrotech.domain.service.IUserRoleService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository userRoleRepository;
    
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Page<UserRole> getAllUserRoles(Pageable pageable) {
        return userRoleRepository.findAll(pageable);
    }
    @Override
    public UserRole getUserRoleById(Long userRoleId) {
        return userRoleRepository.findById(userRoleId).orElseThrow(
                () -> new ResourceNotFoundException("UserRole", "Id",userRoleId));
    }

    @Override
    public UserRole getUserRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id",userId));
    }

    @Override
    public UserRole createUserRole(Long userId, Long roleId, UserRole userRole) {
        return userRepository.findById(userId).map(user-> {
            userRole.setUser(user);
            return roleRepository.findById(roleId).map(role -> {
                userRole.setRole(role);
                return userRoleRepository.save(userRole);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Role", "Id", roleId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }


    @Override
    public ResponseEntity<?> deleteUserRole(Long userRoleId) {
        UserRole userRole = userRoleRepository.findById(userRoleId).orElseThrow(
                ()-> new ResourceNotFoundException("UserRole","Id",userRoleId));
        userRoleRepository.delete(userRole);
        return ResponseEntity.ok().build();
    }
}
