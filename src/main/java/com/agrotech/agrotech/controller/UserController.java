package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.User;
import com.agrotech.agrotech.domain.service.IUserService;
import com.agrotech.agrotech.resource.SaveUserResource;
import com.agrotech.agrotech.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Users", description = "Users API")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IUserService userService;

    private UserResource convertToResource(User entity){
        return mapper.map(entity, UserResource.class);
    }
    private User convertToEntity(SaveUserResource resource){
        return mapper.map(resource, User.class);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary="Get All Users")
    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable){
        Page<User> userPage = userService.getAllUsers(pageable);
        List<UserResource> resources = userPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get User By Id")
    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable(value = "userId") Long userId){
        return convertToResource(userService.getUserById(userId));
    }

    @Operation(summary="Create User")
    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @Operation(summary="Update User")
    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId, @Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource(
                userService.updateUser(userId,user));

    }

    @Operation(summary="Delete User")
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
