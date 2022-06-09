package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlotSensor;
import com.agrotech.agrotech.domain.model.UserRole;
import com.agrotech.agrotech.domain.service.IUserRoleService;
import com.agrotech.agrotech.resource.SavePlotSensorResource;
import com.agrotech.agrotech.resource.SaveUserRoleResource;
import com.agrotech.agrotech.resource.UserRoleResource;
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

@Tag(name = "User_Roles", description = "User Roles API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserRoleController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IUserRoleService userRoleService;

    private UserRoleResource convertToResource(UserRole entity){
        return mapper.map(entity, UserRoleResource.class);
    }

    private UserRole convertToEntity(SaveUserRoleResource resource){
        return mapper.map(resource, UserRole.class);
    }

    @Operation(summary="Get All User Roles")
    @GetMapping("/userRoles")
    public Page<UserRoleResource> getAllUserRoles(Pageable pageable){
        Page<UserRole> userRolePage = userRoleService.getAllUserRoles(pageable);
        List<UserRoleResource> resources = userRolePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get User Role By Id")
    @GetMapping("/userRoles/{userRoleId}")
    public UserRoleResource getUserRoleById(@PathVariable(value = "userRoleId") Long userRoleId){
        return convertToResource(userRoleService.getUserRoleById(userRoleId));
    }

    @Operation(summary="Create User Role")
    @PostMapping("/users/{userId}/roles/{roleId}")
    public UserRoleResource createUserRole(@PathVariable(value = "userId") Long userId,
                                               @PathVariable(value = "roleId") Long roleId,
                                               @Valid @RequestBody SaveUserRoleResource resource){
        UserRole userRole = convertToEntity(resource);
        return convertToResource(userRoleService.createUserRole(userId,roleId,convertToEntity(resource)));
    }

    @Operation(summary="Delete User Role")
    @DeleteMapping("/userRoles/{userRoleId}")
    public ResponseEntity<?> deleteUserRole(@PathVariable Long userRoleId){
        return userRoleService.deleteUserRole(userRoleId);
    }
}
