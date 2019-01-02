package com.codecool.mexicocity.dao;


import com.codecool.mexicocity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(@Param("email") String email);

    User findUserByName(@Param("name") String name);

}
