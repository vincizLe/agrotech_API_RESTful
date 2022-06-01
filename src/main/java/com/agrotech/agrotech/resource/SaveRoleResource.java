package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SaveRoleResource {
    private String name;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public SaveRoleResource setName(String name) {
        this.name = name;
        return this;
    }
}
