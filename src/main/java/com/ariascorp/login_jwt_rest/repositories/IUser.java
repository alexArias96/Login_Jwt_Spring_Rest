package com.ariascorp.login_jwt_rest.repositories;


import com.ariascorp.login_jwt_rest.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUser extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User u set u.firstname=:firstname, u.surname=:surname, u.contact=:contact, u.address=:address where u.id =:id")
    void updateUser(@Param(value = "id") Integer id,
                    @Param(value = "firstname") String firstname,
                    @Param(value = "surname") String surname,
                    @Param(value = "contact") String contact,
                    @Param(value = "address") String address);
}
