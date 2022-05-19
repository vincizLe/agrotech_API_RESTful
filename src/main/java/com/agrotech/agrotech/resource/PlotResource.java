package com.agrotech.agrotech.resource;

import com.agrotech.agrotech.domain.model.User;

import javax.validation.constraints.NotNull;

public class PlotResource {
    private Long id;

    private String name;

    private String description;

    private String location;

    private Float area;

    private Float volume;

    private String plotImage;

    private Long userId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlotResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlotResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlotResource setLocation(String location) {
        this.location = location;
        return this;
    }

    public Float getArea() {
        return area;
    }

    public PlotResource setArea(Float area) {
        this.area = area;
        return this;
    }

    public Float getVolume() {
        return volume;
    }

    public PlotResource setVolume(Float volume) {
        this.volume = volume;
        return this;
    }

    public String getPlotImage() {
        return plotImage;
    }

    public PlotResource setPlotImage(String plotImage) {
        this.plotImage = plotImage;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public PlotResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
