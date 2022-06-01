package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class RoleResource {

    private Long id;

    private String name;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public RoleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleResource setName(String name) {
        this.name = name;
        return this;
    }
}
