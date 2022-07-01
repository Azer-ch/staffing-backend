package com.staffing.authentication.service;

import com.staffing.admin.entity.Admin;
import com.staffing.dto.AuthRequest;
import com.staffing.dto.AuthResponse;
import com.staffing.jwt.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtTokenUtil jwtUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    public AuthResponse login(AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            Admin admin = (Admin) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(admin);
            return new AuthResponse(admin.getEmail(), accessToken);
        } catch (BadCredentialsException ex) {
            LOGGER.error("Bad credentials", ex);
            throw ex;
        }
    }

}
