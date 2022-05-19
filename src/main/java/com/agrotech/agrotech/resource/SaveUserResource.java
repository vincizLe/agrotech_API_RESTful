package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SaveUserResource {

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private Long dni;

    @NotNull
    private Long cellphoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String profileImage;

    @NotNull
    private Boolean accessType;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveUserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public SaveUserResource setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }

    public SaveUserResource setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public SaveUserResource setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public Boolean getAccessType() {
        return accessType;
    }

    public SaveUserResource setAccessType(Boolean accessType) {
        this.accessType = accessType;
        return this;
    }
}
