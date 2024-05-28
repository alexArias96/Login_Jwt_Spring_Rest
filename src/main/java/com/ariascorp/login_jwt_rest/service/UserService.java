package com.ariascorp.login_jwt_rest.service;

import com.ariascorp.login_jwt_rest.model.entities.ERole;
import com.ariascorp.login_jwt_rest.model.entities.User;
import com.ariascorp.login_jwt_rest.repositories.IUser;
import com.ariascorp.login_jwt_rest.request.UserDTO;
import com.ariascorp.login_jwt_rest.request.UserRequest;
import com.ariascorp.login_jwt_rest.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUser userRepository;

    @Transactional
    public UserResponse updateUser(UserRequest userRequest){
        User user = User.builder()
                .id(userRequest.getId())
                .firstname(userRequest.getFirstname())
                .surname(userRequest.getSurname())
                .contact(userRequest.getContact())
                .address(userRequest.getAddress())
                .role(ERole.USER)
                .build();

        userRepository.updateUser(user.getId(), user.getFirstname(),user.getSurname(), user.getContact(), user.getAddress());
        return new UserResponse("The user has successfully registered");
    }

    public UserDTO getUser(Integer id){
        User user = userRepository.findById(id).orElse(null);

        if (user != null){
            return UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .surname(user.getSurname())
                    .contact(user.getContact())
                    .address(user.getAddress())
                    .build();
        }
        return null;
    }
}
