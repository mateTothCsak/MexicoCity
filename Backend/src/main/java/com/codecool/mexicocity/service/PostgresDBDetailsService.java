package com.codecool.mexicocity.service;


import com.codecool.mexicocity.dao.RoosterRepository;
import com.codecool.mexicocity.dao.UserRepository;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PostgresDBDetailsService implements UserDetailsService {
    UserRepository userRepository;
    RoosterRepository roosterRepository;

    @Autowired
    public PostgresDBDetailsService(UserRepository userRepository, RoosterRepository roosterRepository) {
        this.userRepository = userRepository;
        this.roosterRepository = roosterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
