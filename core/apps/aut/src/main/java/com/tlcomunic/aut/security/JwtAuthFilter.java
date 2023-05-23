package com.tlcomunic.aut.security;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
        throws ServletException, IOException {

            final String authHeader = request.getHeader("Authorization");
            final StringBuilder jwt = new StringBuilder();

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                log.info(authHeader.replace("Bearer ", ""));

                jwt.append(authHeader.replace("Bearer ", ""));

//                boolean isValid = jwtService.verify(jwt);
//                if (isValid) {
//                      
//                } else

            }
            else
                throw new RuntimeException("Token is missing");

    }
    
}
