package com.ariascorp.login_jwt_rest.service;

import com.ariascorp.login_jwt_rest.model.entities.ERole;
import com.ariascorp.login_jwt_rest.model.entities.User;
import com.ariascorp.login_jwt_rest.repositories.IUser;
import com.ariascorp.login_jwt_rest.request.LoginRequest;
import com.ariascorp.login_jwt_rest.request.RegisterRequest;
import com.ariascorp.login_jwt_rest.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUser userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private  final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstname(request.getUsername())
                .surname(request.getSurname())
                .address(request.getAddress())
                .contact(request.getContact())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(ERole.USER)
                .build();
        userRepository.save(user);

        return AuthResponse
                .builder()
                .token(jwtService.getToken(user))
                .build();
    }
}