package com.ariascorp.login_jwt_rest.repositories;


import com.ariascorp.login_jwt_rest.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUser extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
