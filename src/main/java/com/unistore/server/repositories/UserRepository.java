package com.unistore.server.repositories;

import com.unistore.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Find user by username
    Optional<User> findByUsername(String username);

    //Check exists an user by username
    Boolean existsByUsername(String username);

    //Check exists an user email
    Boolean existsByEmail(String email);

    //Check enable
    @Query(value = "select enable from users where username = :username", nativeQuery = true)
    Boolean isEnable(@Param("username") String username);
}
