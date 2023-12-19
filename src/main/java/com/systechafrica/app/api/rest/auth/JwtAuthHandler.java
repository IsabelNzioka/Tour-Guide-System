package com.systechafrica.app.api.rest.auth;

import com.systechafrica.app.model.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtAuthHandler {
    private final String SECRET_KEY = "6sJ8vLkR2zLwT5y8uBxZ3G6c9W2zE5vH8yJ1k4n7qM2pS5t8wBzH3N6T9Q1vV4z";

    public String  generateToken(User user){
        return Jwts.builder()
                .claim("ROLE",user.getRole())
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()*1000*60*24))
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
         SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        return key;
    }

    public boolean isValidToken(String token) {
        if (token == null) {
            return false;
        }

        try {
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private Claims getTokenClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token).getPayload();

    }
}
