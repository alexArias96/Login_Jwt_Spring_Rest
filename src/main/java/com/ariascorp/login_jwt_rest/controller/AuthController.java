package com.ariascorp.login_jwt_rest.controller;

import com.ariascorp.login_jwt_rest.request.LoginRequest;
import com.ariascorp.login_jwt_rest.request.RegisterRequest;
import com.ariascorp.login_jwt_rest.response.AuthResponse;
import com.ariascorp.login_jwt_rest.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200"})
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
