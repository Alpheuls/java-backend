package com.shati.solution.api.authentication.controller;

import com.shati.solution.api.authentication.model.dto.AuthenticationDto;
import com.shati.solution.api.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/{userId}")
    public ResponseEntity<AuthenticationDto> createToken(@PathVariable String userId) {
        AuthenticationDto response = new AuthenticationDto();
        try{
            response = authenticationService.createToken(userId);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<AuthenticationDto> validateToken(@PathVariable String userId, HttpServletRequest request) {
        AuthenticationDto response = new AuthenticationDto();
        try{
            response = authenticationService.validateToken(userId, request);
            if (response.getAuthToken().equals("Unauthorized!")){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
