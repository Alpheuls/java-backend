package com.shati.solution.api.authentication.model.dto;

import com.shati.solution.api.authentication.model.Authentication;

public class AuthenticationDto {

    private String userId;
    private String authToken;

    public AuthenticationDto toDto(Authentication authentication){
        return new AuthenticationDto(authentication.getUserId().getUserId(), authentication.getAuthToken());
    }

    public AuthenticationDto() {
    }

    public AuthenticationDto(String userId, String authToken) {
        this.userId = userId;
        this.authToken = authToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
