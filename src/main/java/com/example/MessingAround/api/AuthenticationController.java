package com.example.MessingAround.api;

import com.example.MessingAround.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.stream.Collectors;


@RestController
    @CrossOrigin
    public class AuthenticationController {

        @Autowired
        JwtEncoder encoder;

        @Autowired
        private ApplicationContext applicationContext;

        @GetMapping("/api/csrf")
        public ResponseEntity<String> getCsrf(){
            return new ResponseEntity<>("Csrf sent", HttpStatus.OK);
        }

        @PostMapping("/api/login")
        @ResponseBody
        public ResponseEntity<HashMap<String,String>> token(@RequestBody User user) {
            HashMap<String, String> response = new HashMap<>();
            AuthenticationManager manager = applicationContext.getBean(AuthenticationManager.class);
            Authentication authentication = null;
            try {
                authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            } catch (Exception e) {
                System.out.println(e);
            }
            if (authentication.isAuthenticated()) {
                Instant now = Instant.now();
                long expiry = 36000L;
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
                response.put("Authorization", "Bearer " + this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("Error", "Could not authenticate");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        }
    }
