package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SaveChiliResource {
    @NotNull
    private String name;

    @NotNull
    private String description;

    //Getters and Setters

    public String getName() {
        return name;
    }

    public SaveChiliResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveChiliResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
