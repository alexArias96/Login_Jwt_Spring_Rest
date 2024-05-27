package com.ariascorp.login_jwt_rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String surname;
    private String address;
    private String contact;
    private String username;
    private String password;
    private String role;
}
