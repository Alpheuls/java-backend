package com.shati.solution.api.authentication.service;

import com.shati.solution.api.authentication.model.dto.AuthenticationDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    AuthenticationDto createToken(String userId);

    AuthenticationDto validateToken(String userId, HttpServletRequest request);
}
