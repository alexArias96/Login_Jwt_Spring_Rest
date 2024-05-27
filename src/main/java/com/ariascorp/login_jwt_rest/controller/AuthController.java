package com.ariascorp.login_jwt_rest.controller;

import com.ariascorp.login_jwt_rest.request.LoginRequest;
import com.ariascorp.login_jwt_rest.request.RegisterRequest;
import com.ariascorp.login_jwt_rest.response.AuthResponse;
import com.ariascorp.login_jwt_rest.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        log.info("Init endpoint register, request: " + request);
        return ResponseEntity.ok(authService.register(request));
    }

}
