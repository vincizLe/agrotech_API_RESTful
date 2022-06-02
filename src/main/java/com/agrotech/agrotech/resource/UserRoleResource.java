package com.agrotech.agrotech.resource;

public class UserRoleResource {
    private Long id;
    private Long userId;
    private Long roleId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public UserRoleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRoleResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public UserRoleResource setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }
}
