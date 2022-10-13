package com.example.MessingAround.api;


import com.example.MessingAround.model.User;
import com.example.MessingAround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtEncoder jwtEncoder;


    @PostMapping("/api/users")
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> createUser(@RequestBody User user) {
        User newUser = User
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .build();

        Instant now = Instant.now();
        long expiry = 36000L;
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(newUser.getEmail())
                .build();

        HashMap<String, String> response = new HashMap<>();
        response.put("Authorization", "Bearer " + this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        userRepository.save(newUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
