package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class PlagueResource {
    private Long id;

    private String description;

    private String type;

    private String phThreshold;

    private String temperatureThreshold;

    private String humidityThreshold;

    private String co2Threshold;

    private String electricConductivityThreshold;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlagueResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlagueResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public PlagueResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getPhThreshold() {
        return phThreshold;
    }

    public PlagueResource setPhThreshold(String phThreshold) {
        this.phThreshold = phThreshold;
        return this;
    }

    public String getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public PlagueResource setTemperatureThreshold(String temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
        return this;
    }

    public String getHumidityThreshold() {
        return humidityThreshold;
    }

    public PlagueResource setHumidityThreshold(String humidityThreshold) {
        this.humidityThreshold = humidityThreshold;
        return this;
    }

    public String getCo2Threshold() {
        return co2Threshold;
    }

    public PlagueResource setCo2Threshold(String co2Threshold) {
        this.co2Threshold = co2Threshold;
        return this;
    }

    public String getElectricConductivityThreshold() {
        return electricConductivityThreshold;
    }

    public PlagueResource setElectricConductivityThreshold(String electricConductivityThreshold) {
        this.electricConductivityThreshold = electricConductivityThreshold;
        return this;
    }
}
