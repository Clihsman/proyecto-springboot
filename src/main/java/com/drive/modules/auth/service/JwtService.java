package com.drive.modules.auth.service;

import java.security.MessageDigest;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.drive.tools.Result;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    public Result<String> generateToken(String id, Map<String, ?> claims) {

        final Result<SecretKey> key = getSignInKey();

        if (key.isError())
            return Result.error(key);

        return Result.success(Jwts.builder()
                .id(id)
                .claims(claims)
                .signWith(key.getValue())
                .compact());
    }

    private Result<SecretKey> getSignInKey() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = Decoders.BASE64.decode("SecretKey1450303485");
            byte[] hash = digest.digest(keyBytes);
            return Result.success(Keys.hmacShaKeyFor(hash));
        } catch (Exception ex) {
            return Result.error(ex, JwtService.class, "getSignInKey");
        }
    }
}
