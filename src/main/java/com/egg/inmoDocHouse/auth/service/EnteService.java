package com.egg.inmoDocHouse.auth.service;

import com.egg.inmoDocHouse.auth.entity.User;
import com.egg.inmoDocHouse.auth.entity.Ente;
import com.egg.inmoDocHouse.auth.repository.EnteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class EnteService implements UserDetailsService {

    @Autowired
    private EnteRepository enteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Ente ente = enteRepository.findByUsername(username);
        if (ente == null) {
            throw new UsernameNotFoundException("Username or password not found");

        }

        return new org.springframework.security.core.userdetails.User(ente.getUsername(), ente.getPassword(), Collections.emptyList());

    }

    public boolean save(Ente enteRequest) {
        Ente ente = new Ente();
        ente.setUsername(enteRequest.getUsername());
        ente.setPassword(enteRequest.getPassword());
        ente = enteRepository.save(ente);
        return ente != null;

    }
}
