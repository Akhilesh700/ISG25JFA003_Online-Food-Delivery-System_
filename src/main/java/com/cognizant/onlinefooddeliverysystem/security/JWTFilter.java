package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.exception.login.NoUsersFoundWithUsername;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class JWTFilter extends OncePerRequestFilter {

    private final AuthUtil authUtil;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//      Getting header containing JWT Token
        final String requestTokenHeader = request.getHeader("Authorization");
//      Checking if the token header is null or invalid
            if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
//         Removing the "Bearer " part from the token
            String token = requestTokenHeader.split("Bearer ")[1];
//         Function to get username from the token
            String username = authUtil.getUsernameFromToken(token);
//            Finding user with the email
            User user = userRepository.findUserByEmail(username).orElseThrow(
                    () -> new NoUsersFoundWithUsername("User not found with username : " + username)
            );

//           Getting "role" from the user
            String role = user.getRole().toString();
//        Checking if the username exists and Authentication of SecurityContextHolder is not set
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                if (role == null) {
                    logger.warn("JWT for user" +  user.getUserId() + "has an invalid role claim.");
                    filterChain.doFilter(request, response);
                    return; // Stop processing and reject the token
                }

//               Creating a list of authorities from the role string
                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));

//            Creating the authentication token by username, credentials and user's authorities
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
//            Finally setting the Authentication of SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
//            Moving to next filter
        filterChain.doFilter(request, response);
    }
}
