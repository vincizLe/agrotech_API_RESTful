package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SensorResource {
    private Long id;

    private String name;

    private String type;

    private String description;

    private int usefulLife;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public SensorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SensorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public SensorResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SensorResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getUsefulLife() {
        return usefulLife;
    }

    public SensorResource setUsefulLife(int usefulLife) {
        this.usefulLife = usefulLife;
        return this;
    }
}
