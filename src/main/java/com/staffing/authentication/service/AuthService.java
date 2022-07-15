package com.staffing.authentication.service;

import com.staffing.dto.AuthRequest;
import com.staffing.dto.AuthResponse;
import com.staffing.jwt.JwtTokenUtil;
import com.staffing.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private  AuthenticationManager authManager;
    @Autowired
    private  JwtTokenUtil jwtUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    public AuthResponse login(AuthRequest request) throws Exception {
        try {
            if(request.getPassword().length()<8){
                throw new Exception("Password must be at least 8 characters long");
            }
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            return new AuthResponse(user, accessToken);
        } catch (BadCredentialsException ex) {
            LOGGER.error("Bad credentials", ex);
            throw ex;
        }
    }

}
