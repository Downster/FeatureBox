package com.example.MessingAround.api;


import com.example.MessingAround.model.User;
import com.example.MessingAround.repository.UserRepository;
import com.example.MessingAround.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        User newUser = User
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .build();

        return userRepository.save(newUser);
    }
}
