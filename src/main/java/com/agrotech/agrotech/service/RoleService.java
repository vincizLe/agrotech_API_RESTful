package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Role;
import com.agrotech.agrotech.domain.repository.IRoleRepository;
import com.agrotech.agrotech.domain.service.IRoleService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(
                () -> new ResourceNotFoundException("Role", "Id",roleId));
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long roleId, Role roleRequest) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(()-> new ResourceNotFoundException("Role","Id",roleId));
        return roleRepository.save(role
                .setName(roleRequest.getName())
        );
    }

    @Override
    public ResponseEntity<?> deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(
                ()-> new ResourceNotFoundException("Role","Id",roleId));
        roleRepository.delete(role);
        return ResponseEntity.ok().build();
    }
}
