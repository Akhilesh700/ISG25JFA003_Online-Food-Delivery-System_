package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.refreshtoken.RefreshTokenResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.refreshtoken.TokenRefreshException;
import com.cognizant.onlinefooddeliverysystem.model.RefreshToken;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.RefreshTokenRepository;
import com.cognizant.onlinefooddeliverysystem.security.AuthUtil;
import com.cognizant.onlinefooddeliverysystem.service.RefreshTokenService;
import com.cognizant.onlinefooddeliverysystem.util.GenerateRefreshToken;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthUtil authUtil;
    private final GetVerifiedUser getVerifiedUser;
    private final GenerateRefreshToken generateRefreshToken;
    /**
     * Finds a refresh token by its token string.
     * @param token The refresh token string.
     * @return An Optional containing the RefreshToken entity if found.
     */
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    /**
     * Verifies that the refresh token is not expired and not revoked.
     * @param token The RefreshToken entity.
     * @return The same RefreshToken entity if valid.
     * @throws TokenRefreshException if the token is expired or revoked.
     */
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.isRevoked()) {
             refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was revoked!");
        }
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token); // Deleting expired token
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new login request");
        }
        return token;
    }

    /**
     * Generates a new access token based on a valid refresh token.
     * Handles finding, verifying, and potentially rotating the refresh token.
     *
     * @param requestRefreshToken The refresh token string provided by the client.
     * @return A DTO containing the new access token (and potentially a new refresh token).
     * @throws TokenRefreshException if the refresh token is invalid, expired, or revoked.
     */
    @Transactional
    @Override
    public RefreshTokenResponseDto generateJwtTokenByRefreshToken(String requestRefreshToken) {
        // 1. Find the token and verify it exists, is not expired, and not revoked
        RefreshToken refreshToken = findByToken(requestRefreshToken)
                .map(this::verifyExpiration)
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token not found!"));




        // Generating a new refresh token string
        String newRefreshTokenString = generateRefreshToken.generateRefreshToken();

        // Creating and save the new RefreshToken entity
        RefreshToken newRefreshToken = new RefreshToken();
        newRefreshToken.setDeviceInfo(refreshToken.getDeviceInfo());
        newRefreshToken.setToken(newRefreshTokenString);
        newRefreshToken.setUser(refreshToken.getUser());
        newRefreshToken.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS));
        refreshTokenRepository.save(newRefreshToken);


        // 2. Getting the associated user
        User user = refreshToken.getUser();

        // 3. Generating a new JWT Access Token
        String newAccessToken = authUtil.generateJwtToken(user);



        // 4. Deleting the old token for security
        refreshTokenRepository.delete(refreshToken);

        // 5. Create and return the response DTO

        return new RefreshTokenResponseDto(
                newAccessToken,
                newRefreshTokenString
        );
    }

}
