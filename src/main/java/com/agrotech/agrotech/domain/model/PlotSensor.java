package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plot_sensors")
public class PlotSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    @NotNull
    private String location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="plot_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plot plot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sensor_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sensor sensor;

    public Long getId() {
        return id;
    }

    public PlotSensor setId(Long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PlotSensor setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlotSensor setLocation(String location) {
        this.location = location;
        return this;
    }

    public Plot getPlot() {
        return plot;
    }

    public PlotSensor setPlot(Plot plot) {
        this.plot = plot;
        return this;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public PlotSensor setSensor(Sensor sensor) {
        this.sensor = sensor;
        return this;
    }
}
