package com.tlcomunic.aut.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.service.TokenService;

public class JsonWebTokenService implements TokenService {

    private JwtEncoder encoder;

    JsonWebTokenService(final JwtEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String generate(User user) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("Self")
            .issuedAt(now)
            .expiresAt(now.plus(1L, ChronoUnit.HOURS))
            .claim("Role", user.getRole())
            .subject(user.getFirstName().concat(" ").concat(user.getLastName()))
            .build();
        
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @Override
    public Boolean verify(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }
    
}
