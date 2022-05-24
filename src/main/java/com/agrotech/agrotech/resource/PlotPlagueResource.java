package com.agrotech.agrotech.resource;

import java.util.Date;

public class PlotPlagueResource {
    private Long id;

    private Date startDate;

    private Date endDate;

    private String damage;

    private Long plotId;

    private Long plagueId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotPlagueResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotPlagueResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotPlagueResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDamage() {
        return damage;
    }

    public PlotPlagueResource setDamage(String damage) {
        this.damage = damage;
        return this;
    }

    public Long getPlotId() {
        return plotId;
    }

    public PlotPlagueResource setPlotId(Long plotId) {
        this.plotId = plotId;
        return this;
    }

    public Long getPlagueId() {
        return plagueId;
    }

    public PlotPlagueResource setPlagueId(Long plagueId) {
        this.plagueId = plagueId;
        return this;
    }
}
