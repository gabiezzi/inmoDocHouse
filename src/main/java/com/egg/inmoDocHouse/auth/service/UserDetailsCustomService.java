package com.egg.inmoDocHouse.auth.service;


import com.egg.inmoDocHouse.auth.entity.User;
import com.egg.inmoDocHouse.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        User userEntity = userRepository.findByUsername(userName);
        if (userEntity==null){
            throw new UsernameNotFoundException("Username or password not found");

        }

        return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword() , Collections.emptyList());

    }

    public boolean save(User userRequest){
        User userEntity = new User();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        userEntity = userRepository.save(userEntity);


        return userEntity!=null;

    }
}