package com.capstone.project.controller;

import com.capstone.project.DTO.AuthBody;
import com.capstone.project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthBody authBody){
        try {
            //authenticating the username and password because we kept this api away from authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authBody.username,authBody.password)
            );
            //return the jwt token
            return jwtUtil.jwtTokenGenerator(authBody.username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
