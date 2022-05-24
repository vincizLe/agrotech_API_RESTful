package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePlotChiliResource {
    @NotNull
    private String location;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    //Getters and Setters
    public String getLocation() {
        return location;
    }

    public SavePlotChiliResource setLocation(String location) {
        this.location = location;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SavePlotChiliResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SavePlotChiliResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
