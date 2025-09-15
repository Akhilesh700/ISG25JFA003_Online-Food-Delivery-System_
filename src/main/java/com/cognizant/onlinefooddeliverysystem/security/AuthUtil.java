package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {
    @Value("${jwt.secretKey}")
    private String secretKey;

    //Converting the key to hmacShaKey Algorithm
    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //Generating the jwt token
    public String generateJwtToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getUserId().toString())
                .issuedAt(new Date())
                //Setting the token expiry time to current time + 15 mins
                .expiration(new Date(System.currentTimeMillis() + 1000*60*15))
                //Passing the secret Key
                .signWith(getSecretKey())
                .compact();
    }
}
