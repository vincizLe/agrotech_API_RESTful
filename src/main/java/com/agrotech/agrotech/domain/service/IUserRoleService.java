package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IUserRoleService {
    Page<UserRole> getAllUserRoles(Pageable pageable);
    UserRole getUserRoleById(Long userRoleId);
    UserRole createUserRole(Long plotId, Long sensorId, UserRole userRole);
    ResponseEntity<?> deleteUserRole(Long userRoleId);
}
