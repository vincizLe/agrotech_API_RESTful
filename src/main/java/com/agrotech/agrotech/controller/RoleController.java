package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Role;
import com.agrotech.agrotech.domain.service.IRoleService;
import com.agrotech.agrotech.resource.SaveRoleResource;
import com.agrotech.agrotech.resource.RoleResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Roles",description = "Roles API")
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IRoleService roleService;

    private RoleResource convertToResource(Role entity){
        return mapper.map(entity, RoleResource.class);
    }
    private Role convertToEntity(SaveRoleResource resource){
        return mapper.map(resource, Role.class);
    }

    @Operation(summary="Get All Roles")
    @GetMapping("/roles")
    public Page<RoleResource> getAllRoles(Pageable pageable){
        Page<Role> rolePage = roleService.getAllRoles(pageable);
        List<RoleResource> resources = rolePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Role By Id")
    @GetMapping("/roles/{roleId}")
    public RoleResource getRoleById(@PathVariable(value = "roleId") Long roleId){
        return convertToResource(roleService.getRoleById(roleId));
    }

    @Operation(summary="Create Role")
    @PostMapping("/roles")
    public RoleResource createRole(@Valid @RequestBody SaveRoleResource resource){
        Role role = convertToEntity(resource);
        return convertToResource(roleService.createRole(role));
    }

    @Operation(summary="Update Role")
    @PutMapping("/roles/{roleId}")
    public RoleResource updateRole(@PathVariable Long roleId, @Valid @RequestBody SaveRoleResource resource){
        Role role = convertToEntity(resource);
        return convertToResource(
                roleService.updateRole(roleId,role));

    }

    @Operation(summary="Delete Role")
    @DeleteMapping("/roles/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long roleId){
        return roleService.deleteRole(roleId);
    }
}
