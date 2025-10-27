package com.cognizant.onlinefooddeliverysystem.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class GenerateRefreshToken {
    private static final SecureRandom secureRandom = new SecureRandom(); // Thread-safe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder().withoutPadding(); // URL-safe, no padding


    private static final int REFRESH_TOKEN_BYTE_LENGTH = 48; // e.g., 48 bytes = 384 bits, generates a ~64 char Base64 string

    /**
     * Generates a cryptographically secure, random string suitable for use as a refresh token.
     * The token is Base64 URL-safe encoded.
     *
     * @return A secure refresh token string.
     */
    public String generateRefreshToken() {
        byte[] randomBytes = new byte[REFRESH_TOKEN_BYTE_LENGTH];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
