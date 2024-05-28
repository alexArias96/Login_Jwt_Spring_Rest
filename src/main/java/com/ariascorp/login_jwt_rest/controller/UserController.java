package com.ariascorp.login_jwt_rest.controller;

import com.ariascorp.login_jwt_rest.request.UserDTO;
import com.ariascorp.login_jwt_rest.request.UserRequest;
import com.ariascorp.login_jwt_rest.response.UserResponse;
import com.ariascorp.login_jwt_rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getUser(@PathVariable Integer id){
        UserDTO userDTO = userService.getUser(id);

        if(userDTO==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.updateUser(request));
    }
}