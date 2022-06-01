package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IRoleService {
    Page<Role> getAllRoles(Pageable pageable);
    Role getRoleById(Long roleId);
    Role createRole(Role role);
    Role updateRole(Long roleId,Role roleRequest);
    ResponseEntity<?> deleteRole(Long roleId);
}
