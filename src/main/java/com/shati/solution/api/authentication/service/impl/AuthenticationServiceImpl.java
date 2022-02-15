package com.shati.solution.api.authentication.service.impl;

import com.shati.solution.api.authentication.model.Authentication;
import com.shati.solution.api.authentication.model.User;
import com.shati.solution.api.authentication.model.dto.AuthenticationDto;
import com.shati.solution.api.authentication.repository.AuthenticationRepository;
import com.shati.solution.api.authentication.repository.UserRepository;
import com.shati.solution.api.authentication.service.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private UserRepository userRepository;

    private final SecretKey key = Keys.hmacShaKeyFor("api.shati-solution-authentication@2022".getBytes(StandardCharsets.UTF_8));


    @Override
    public AuthenticationDto createToken(String userId) {
        AuthenticationDto response = new AuthenticationDto();
        try{

            Authentication authentication = new Authentication();
            authentication.setAuthToken(Jwts.builder()
                    .setSubject(userId)
                    .setIssuedAt(new Date())
                    .setExpiration(
                            Date.from(
                                    LocalDateTime.now().plusMinutes(30L)
                                            .atZone(ZoneId.systemDefault())
                                            .toInstant()))
                    .signWith(key)
                    .compact());
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
    public AuthenticationDto validateToken(String userId, HttpServletRequest request) {
        AuthenticationDto response = new AuthenticationDto();
       try{
           filter(request);
           String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
           String token = authorizationHeader.substring("Bearer".length()).trim();
           User user = userRepository.findByUserId(userId);
           Authentication authentication = authenticationRepository.findByUserAndTokenAndChannel(user, token, "SSFE");
           if(authentication.getStatus().equals("1")){
               authentication.setStatus("0");
               authenticationRepository.save(authentication);
           }else{
              response.setAuthToken("Unauthorized!");
              response.setUserId(userId);
              return  response;
           }
           return response = createToken(userId);
       }
       catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    public void filter(HttpServletRequest request) throws IOException {
        String authorizationHeader = request
                .getHeader(HttpHeaders.AUTHORIZATION);
        try {
            String token = authorizationHeader.substring("Bearer".length()).trim();

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
