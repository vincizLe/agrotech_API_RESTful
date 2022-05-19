package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SavePlotResource {
    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String location;

    @NotNull
    private Float area;

    @NotNull
    private Float volume;

    @NotNull
    private String plotImage;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public SavePlotResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SavePlotResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SavePlotResource setLocation(String location) {
        this.location = location;
        return this;
    }

    public Float getArea() {
        return area;
    }

    public SavePlotResource setArea(Float area) {
        this.area = area;
        return this;
    }

    public Float getVolume() {
        return volume;
    }

    public SavePlotResource setVolume(Float volume) {
        this.volume = volume;
        return this;
    }

    public String getPlotImage() {
        return plotImage;
    }

    public SavePlotResource setPlotImage(String plotImage) {
        this.plotImage = plotImage;
        return this;
    }
}
