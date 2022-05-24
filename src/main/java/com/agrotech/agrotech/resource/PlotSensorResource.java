package com.agrotech.agrotech.resource;

public class PlotSensorResource {
    private Long id;

    private int quantity;

    private String location;

    private Long plotId;

    private Long sensorId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotSensorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PlotSensorResource setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlotSensorResource setLocation(String location) {
        this.location = location;
        return this;
    }

    public Long getPlotId() {
        return plotId;
    }

    public PlotSensorResource setPlotId(Long plotId) {
        this.plotId = plotId;
        return this;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public PlotSensorResource setSensorId(Long sensorId) {
        this.sensorId = sensorId;
        return this;
    }
}
