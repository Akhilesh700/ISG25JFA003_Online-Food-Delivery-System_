package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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

        try {
            if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
//      Removing the "Bearer " part from the token
            String token = requestTokenHeader.split("Bearer ")[1];
//        Function to get username from the token
            String username = authUtil.getUsernameFromToken(token);

//        Checking if the username exists and Authentication of SecurityContextHolder is not set
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
    //           Fetching the user with the username from DAO
                User user = userRepository.findUserByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("User not found with username : " + username)
                );
    //            Creating the authentication token by user, credentials and user's authorities
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    //            Finally setting the Authentication of SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    //            Moving to next filter

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }
}
