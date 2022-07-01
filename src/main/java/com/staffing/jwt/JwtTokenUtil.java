package com.staffing.jwt;

import com.staffing.admin.entity.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(Admin admin) {

        return Jwts.builder()
                .setSubject(String.format("%s,%s", admin.getId(), admin.getEmail()))
                .claim("roles", admin.getRoles().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
