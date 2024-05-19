package com.keaweaquarian.services.impl;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.Base64.Decoder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.keaweaquarian.fullStackProject1.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTServiceImpl {

    private String generateToken(UserDetails userDetails) {
        
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    } 

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token) {
       return Jwts.parserBuilder()
               .setSigningKey(getSigninKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
    }

    private Key getSigninKey() {
        byte[] key = Decoders.BASE64.decode("mySecretKey");
        return Keys.hmacShaKeyFor(key);
    }
    
}
