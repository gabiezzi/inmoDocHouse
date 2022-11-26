package com.egg.inmoDocHouse.auth.controller;


import com.egg.inmoDocHouse.auth.dto.AuthenticationRequest;
import com.egg.inmoDocHouse.auth.dto.AuthenticationResponse;
import com.egg.inmoDocHouse.auth.entity.Client;
import com.egg.inmoDocHouse.auth.service.ClientService;
import com.egg.inmoDocHouse.auth.service.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/client")
public class ClientAuthController {

    private ClientService clientService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;

    @Autowired
    public ClientAuthController(
            ClientService clientService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil) {

       this.clientService = clientService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody Client client) throws Exception {

        this.clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest) throws Exception {

        UserDetails userDetails;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())

            );

            userDetails = (UserDetails) authentication.getPrincipal();

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }
}
