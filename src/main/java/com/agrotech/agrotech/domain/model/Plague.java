package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plagues")
public class Plague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    public Long getId() {
        return id;
    }

    public Plague setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plague setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public Plague setType(String type) {
        this.type = type;
        return this;
    }

    public String getPhThreshold() {
        return phThreshold;
    }

    public Plague setPhThreshold(String phThreshold) {
        this.phThreshold = phThreshold;
        return this;
    }

    public String getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public Plague setTemperatureThreshold(String temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
        return this;
    }

    public String getHumidityThreshold() {
        return humidityThreshold;
    }

    public Plague setHumidityThreshold(String humidityThreshold) {
        this.humidityThreshold = humidityThreshold;
        return this;
    }

    public String getCo2Threshold() {
        return co2Threshold;
    }

    public Plague setCo2Threshold(String co2Threshold) {
        this.co2Threshold = co2Threshold;
        return this;
    }

    public String getElectricConductivityThreshold() {
        return electricConductivityThreshold;
    }

    public Plague setElectricConductivityThreshold(String electricConductivityThreshold) {
        this.electricConductivityThreshold = electricConductivityThreshold;
        return this;
    }
}
