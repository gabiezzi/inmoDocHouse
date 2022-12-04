package com.egg.inmoDocHouse.controller;

import java.util.Collections;

import com.egg.inmoDocHouse.auth.model.Login;
import com.egg.inmoDocHouse.auth.model.Register;
import com.egg.inmoDocHouse.entity.ClientEntity;
import com.egg.inmoDocHouse.entity.EnteEntity;
import com.egg.inmoDocHouse.entity.Rol;
import com.egg.inmoDocHouse.repository.ClientRepository;
import com.egg.inmoDocHouse.repository.EnteRepository;
import com.egg.inmoDocHouse.repository.RolRepository;
import com.egg.inmoDocHouse.repository.UserRepository;
import com.egg.inmoDocHouse.security.JWTAuthResponse;
import com.egg.inmoDocHouse.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin

public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private EnteRepository enteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> login(@RequestBody Login login){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsernameOrEmail(), login.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResponse(token));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Register register){


		if(userRepository.existsByUsername(register.getUsername())) {
			return new ResponseEntity<>("That username already exists",HttpStatus.BAD_REQUEST);
		}

		if(userRepository.existsByEmail(register.getEmail())) {
			return new ResponseEntity<>("That email already exists",HttpStatus.BAD_REQUEST);
		}

		ClientEntity clientEntity = new ClientEntity();

		clientEntity.setUsername(register.getUsername());
		clientEntity.setEmail(register.getEmail());
		clientEntity.setPassword(passwordEncoder.encode(register.getPassword()));


		Rol roles = rolRepository.findByRolType("ROLE_CLIENT").get();
		clientEntity.setRol(Collections.singleton(roles));

		clientRepository.save(clientEntity);
		return new ResponseEntity<>("Cliente registrado exitosamente",HttpStatus.OK);
	}

	@PostMapping("/signente")
	public ResponseEntity<?> signEnte(@RequestBody Register register){

		if(userRepository.existsByUsername(register.getUsername())) {
			return new ResponseEntity<>("That username already exists",HttpStatus.BAD_REQUEST);
		}

		if(userRepository.existsByEmail(register.getEmail())) {
			return new ResponseEntity<>("That email already exists",HttpStatus.BAD_REQUEST);
		}

		EnteEntity enteEntity = new EnteEntity();

		enteEntity.setUsername(register.getUsername());
		enteEntity.setEmail(register.getEmail());
		enteEntity.setPassword(passwordEncoder.encode(register.getPassword()));


		Rol roles = rolRepository.findByRolType("ROLE_CLIENT").get();
		enteEntity.setRol(Collections.singleton(roles));

		enteRepository.save(enteEntity);
		return new ResponseEntity<>("Cliente registrado exitosamente",HttpStatus.OK);
	}
}
