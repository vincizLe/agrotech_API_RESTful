package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PlotChiliResource {
    private Long id;

    private String location;

    private Date startDate;

    private Date endDate;

    private Long plotId;

    private Long chiliId;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public PlotChiliResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlotChiliResource setLocation(String location) {
        this.location = location;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotChiliResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotChiliResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Long getPlotId() {
        return plotId;
    }

    public PlotChiliResource setPlotId(Long plotId) {
        this.plotId = plotId;
        return this;
    }

    public Long getChiliId() {
        return chiliId;
    }

    public PlotChiliResource setChiliId(Long chiliId) {
        this.chiliId = chiliId;
        return this;
    }
}
