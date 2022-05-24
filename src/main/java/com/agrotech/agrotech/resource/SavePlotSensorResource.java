package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SavePlotSensorResource {
    @NotNull
    private int quantity;

    @NotNull
    private String location;

    //Getters and Setters
    public int getQuantity() {
        return quantity;
    }

    public SavePlotSensorResource setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SavePlotSensorResource setLocation(String location) {
        this.location = location;
        return this;
    }
}
