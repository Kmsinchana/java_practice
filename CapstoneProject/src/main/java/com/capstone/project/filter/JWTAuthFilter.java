package com.capstone.project.filter;

import com.capstone.project.dvo.Users;
import com.capstone.project.repo.UsersRepository;
import com.capstone.project.service.UserService;
import com.capstone.project.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authHeader = request.getHeader("Authorization"); // this should be same as that of postman header authorization(here we needed only authorization)
       String token = null;
        String username = null;

        //extracting the token and username from the header
        if(authHeader!= null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7); // here 7 is used because we get token after the bearer with one space(index always start with 0)
            username = jwtUtil.getSubjectFromToken(token); // validation is done here while fetching the username
        }
        if(username!= null && SecurityContextHolder.getContext().getAuthentication() == null) { // secutitycontext should be empty
            //fetching the userdetails
            UserDetails userDetails = userService.loadUserByUsername(username);
            //2nd time validate the token
            if(jwtUtil.verifyUserAndTokenExpiry(username, userDetails, token)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()); //authentication object spring security needs
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //Sets additional details like IP address, session ID, etc., into the token.
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
