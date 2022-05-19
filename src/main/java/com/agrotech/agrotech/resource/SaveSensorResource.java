package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SaveSensorResource {
    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private int usefulLife;

    public String getName() {
        return name;
    }

    public SaveSensorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public SaveSensorResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSensorResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getUsefulLife() {
        return usefulLife;
    }

    public SaveSensorResource setUsefulLife(int usefulLife) {
        this.usefulLife = usefulLife;
        return this;
    }
}
