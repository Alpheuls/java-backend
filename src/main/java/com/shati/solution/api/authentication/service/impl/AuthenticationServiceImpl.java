package com.shati.solution.api.authentication.service.impl;

import com.shati.solution.api.authentication.model.Authentication;
import com.shati.solution.api.authentication.model.User;
import com.shati.solution.api.authentication.model.dto.AuthenticationDto;
import com.shati.solution.api.authentication.model.dto.AuthenticationValidateDto;
import com.shati.solution.api.authentication.repository.AuthenticationRepository;
import com.shati.solution.api.authentication.repository.UserRepository;
import com.shati.solution.api.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationDto createToken(String userId) {
        AuthenticationDto response = new AuthenticationDto();
        try{
            Authentication authentication = new Authentication();
            authentication.setAuthToken(Base64.getEncoder().toString());
            authentication.setChannelInitials("SSFE");
            authentication.setStatus("1");
            authentication.setUserId(userRepository.findByUserId(userId));
            authentication.setCreateDate(LocalDateTime.now());
            authentication.setUpdateDate(LocalDateTime.now());
            authentication = authenticationRepository.save(authentication);
            response = new AuthenticationDto().toDto(authentication);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public AuthenticationDto validateToken(AuthenticationValidateDto authenticationValidateDto) {
        AuthenticationDto response = new AuthenticationDto();
        long expirationTime = 0l;
        try{
            User user = userRepository.findByUserId(authenticationValidateDto.getUserId());
            Authentication authentication = authenticationRepository.findByUserAndTokenAndChannel(user, authenticationValidateDto.getAuthToken(), authenticationValidateDto.getChannel());
            if(authentication != null && authentication.getStatus().equals("1")){
                expirationTime = authentication.getUpdateDate().until(LocalDateTime.now(), ChronoUnit.MINUTES);
                if(expirationTime < 30){
                    authentication.setAuthToken(Base64.getEncoder().toString());
                    authentication.setUpdateDate(LocalDateTime.now());
                    authentication = authenticationRepository.save(authentication);
                    response = new AuthenticationDto().toDto(authentication);
                }else{
                    authentication.setStatus("0");
                    authentication.setUpdateDate(LocalDateTime.now());
                    authenticationRepository.save(authentication);
                    response.setAuthToken("Token expired!");
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return response;
    }
}
