package com.shati.solution.api.authentication.model.dto;

public class AuthenticationValidateDto {

    private String userId;
    private String authToken;
    private String channel;

    public AuthenticationValidateDto() {
    }

    public AuthenticationValidateDto(String userId, String authToken, String channel) {
        this.userId = userId;
        this.authToken = authToken;
        this.channel = channel;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
