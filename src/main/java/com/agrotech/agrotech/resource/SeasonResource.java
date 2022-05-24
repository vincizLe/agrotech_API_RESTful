package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SeasonResource {
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public SeasonResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SeasonResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SeasonResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SeasonResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
