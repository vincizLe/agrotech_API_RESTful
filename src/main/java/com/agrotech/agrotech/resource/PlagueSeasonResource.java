package com.agrotech.agrotech.resource;

public class PlagueSeasonResource {
    private Long id;

    private Long plagueId;

    private Long seasonId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlagueSeasonResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPlagueId() {
        return plagueId;
    }

    public PlagueSeasonResource setPlagueId(Long plagueId) {
        this.plagueId = plagueId;
        return this;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public PlagueSeasonResource setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
        return this;
    }
}
