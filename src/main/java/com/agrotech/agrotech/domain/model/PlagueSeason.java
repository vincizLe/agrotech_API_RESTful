package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "plague_seasons")
public class PlagueSeason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="plague_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plague plague;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="season_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Season season;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlagueSeason setId(Long id) {
        this.id = id;
        return this;
    }

    public Plague getPlague() {
        return plague;
    }

    public PlagueSeason setPlague(Plague plague) {
        this.plague = plague;
        return this;
    }

    public Season getSeason() {
        return season;
    }

    public PlagueSeason setSeason(Season season) {
        this.season = season;
        return this;
    }
}
