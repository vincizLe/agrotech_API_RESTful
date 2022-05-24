package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SavePlagueResource {
    @NotNull
    private String description;

    @NotNull
    private String type;

    @NotNull
    private String phThreshold;

    @NotNull
    private String temperatureThreshold;

    @NotNull
    private String humidityThreshold;

    @NotNull
    private String co2Threshold;

    @NotNull
    private String electricConductivityThreshold;

    //Getters and Setters
    public String getDescription() {
        return description;
    }

    public SavePlagueResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public SavePlagueResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getPhThreshold() {
        return phThreshold;
    }

    public SavePlagueResource setPhThreshold(String phThreshold) {
        this.phThreshold = phThreshold;
        return this;
    }

    public String getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public SavePlagueResource setTemperatureThreshold(String temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
        return this;
    }

    public String getHumidityThreshold() {
        return humidityThreshold;
    }

    public SavePlagueResource setHumidityThreshold(String humidityThreshold) {
        this.humidityThreshold = humidityThreshold;
        return this;
    }

    public String getCo2Threshold() {
        return co2Threshold;
    }

    public SavePlagueResource setCo2Threshold(String co2Threshold) {
        this.co2Threshold = co2Threshold;
        return this;
    }

    public String getElectricConductivityThreshold() {
        return electricConductivityThreshold;
    }

    public SavePlagueResource setElectricConductivityThreshold(String electricConductivityThreshold) {
        this.electricConductivityThreshold = electricConductivityThreshold;
        return this;
    }
}
