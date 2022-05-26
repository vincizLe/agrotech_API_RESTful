package com.agrotech.agrotech.security;

public class JwtAuthResponseDTO {
    private String tokenOfAccess;
    private String typeOfToken = "Bearer";

    public JwtAuthResponseDTO(String tokenOfAccess) {
        this.tokenOfAccess = tokenOfAccess;
    }

    public JwtAuthResponseDTO(String tokenOfAccess, String typeOfToken) {
        this.tokenOfAccess = tokenOfAccess;
        this.typeOfToken = typeOfToken;
    }

    public String getTokenOfAccess() {
        return tokenOfAccess;
    }


    public JwtAuthResponseDTO setTokenOfAccess(String tokenOfAccess) {
        this.tokenOfAccess = tokenOfAccess;
        return this;
    }

    public String getTypeOfToken() {
        return typeOfToken;
    }

    public JwtAuthResponseDTO setTypeOfToken(String typeOfToken) {
        this.typeOfToken = typeOfToken;
        return this;
    }
}
