package com.agrotech.agrotech.setup;

import javax.validation.constraints.NotNull;

public class SignUpDTO {

    private String name;

    private String lastname;

    private Long dni;

    private Long cellphoneNumber;

    private String email;

    private String password;

    private String profileImage;

    private Boolean accessType;

    public String getName() {
        return name;
    }

    public SignUpDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SignUpDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public SignUpDTO setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }

    public SignUpDTO setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SignUpDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignUpDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public SignUpDTO setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public Boolean getAccessType() {
        return accessType;
    }

    public SignUpDTO setAccessType(Boolean accessType) {
        this.accessType = accessType;
        return this;
    }
}
