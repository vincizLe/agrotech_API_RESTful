package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class ChiliResource {
    private Long id;

    private String name;

    private String description;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public ChiliResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ChiliResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ChiliResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
