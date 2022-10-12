package com.example.MessingAround.api;

import com.example.MessingAround.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;

import java.time.Instant;
import java.util.stream.Collectors;


@RestController
    @CrossOrigin
    public class AuthenticationController {

        @Autowired
        JwtEncoder encoder;

        @Autowired
        private ApplicationContext applicationContext;

        @PostMapping("/api/login")
        public String token(@RequestBody User user) {
            //maybe change type to httpresponse
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            AuthenticationManager manager = applicationContext.getBean(AuthenticationManager.class);
            try {
                manager.authenticate(authentication);
            } catch (Exception e){
                //handle authentication logic here
                return "error";
            }
            Instant now = Instant.now();
            long expiry = 36000L;
            // @formatter:off
            String scope = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiry))
                    .subject(authentication.getName())
                    .claim("scope", scope)
                    .build();
            // @formatter:on
            return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        }
    }
