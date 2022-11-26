package com.egg.inmoDocHouse.auth.service;

import com.egg.inmoDocHouse.auth.entity.User;

import com.egg.inmoDocHouse.auth.entity.Client;
import com.egg.inmoDocHouse.auth.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("Client username or password not found");

        }

        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), Collections.emptyList());

    }

    public boolean save(User clientRequest) {
        Client client = new Client();
        client.setUsername(clientRequest.getUsername());
        client.setPassword(clientRequest.getPassword());
        client = clientRepository.save(client);


        return client != null;

    }
}
