package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveSeasonResource {
    @NotNull
    private String description;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    //Getters and Setters
    public String getDescription() {
        return description;
    }

    public SaveSeasonResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SaveSeasonResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SaveSeasonResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
