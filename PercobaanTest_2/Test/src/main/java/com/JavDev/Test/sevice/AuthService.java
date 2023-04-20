package com.JavDev.Test.sevice;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class AuthService {

    private final String SECRET_KEY = "marikitabuatsebuahrahasiadiantarakita"; // secret key untuk signing JWT
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // waktu token kadaluwarsa (24 jam)

    public String authenticate(String username) {
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key);

        return builder.compact();
    }

    public String getUsernameFromToken(String token) {
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
