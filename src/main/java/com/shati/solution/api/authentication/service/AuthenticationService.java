package com.shati.solution.api.authentication.service;

import com.shati.solution.api.authentication.model.dto.AuthenticationDto;
import com.shati.solution.api.authentication.model.dto.AuthenticationValidateDto;

public interface AuthenticationService {

    AuthenticationDto createToken(String userId);
    AuthenticationDto validateToken(AuthenticationValidateDto authenticationValidateDto);

}
