package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plots")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String location;

    @NotNull
    private Float area;

    @NotNull
    private Float volume;

    @NotNull
    private String plotImage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public Plot setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Plot setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plot setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Plot setLocation(String location) {
        this.location = location;
        return this;
    }

    public Float getArea() {
        return area;
    }

    public Plot setArea(Float area) {
        this.area = area;
        return this;
    }

    public Float getVolume() {
        return volume;
    }

    public Plot setVolume(Float volume) {
        this.volume = volume;
        return this;
    }

    public String getPlotImage() {
        return plotImage;
    }

    public Plot setPlotImage(String plotImage) {
        this.plotImage = plotImage;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Plot setUser(User user) {
        this.user = user;
        return this;
    }
}
