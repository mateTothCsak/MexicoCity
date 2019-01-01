package com.codecool.mexicocity.dao;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RegistrationRepository<T> extends JpaRepository<T, T > {
}
