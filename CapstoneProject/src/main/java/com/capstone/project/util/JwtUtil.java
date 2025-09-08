package com.capstone.project.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    //https://jwt.io/
    //use this website for jwt token structure
    private final String secret = "a-string-secret-at-least-256-bits-long"; // we are using final because we are using this variable only once
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    private final long expiry_time = 1000*60*60; // 1 hour // the warning is regarding that this variable is used only once so we can use that inside the function
   //1000 (ms) * 60 (sec) * 60 (min) = 3,600,000 milliseconds = 1 hour
    public String jwtTokenGenerator(String username){
       return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiry_time))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //this will perform 2 operation one it gives clains(body), and it also validate the token we set the signing key and for parseclaimsJwt we are passing token
    public Claims getTokenBody(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getSubjectFromToken(String token){
       return getTokenBody(token).getSubject();
    }

    public boolean verifyUserAndTokenExpiry(String username, UserDetails userDetails, String token) {
        return(username.equals(userDetails.getUsername()) && !tokenExpiry(token));
    }

    private boolean tokenExpiry(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }
}
