package com.egg.inmoDocHouse.controller;

import java.util.Collections;

import com.egg.inmoDocHouse.auth.model.Login;
import com.egg.inmoDocHouse.auth.model.Registro;
import com.egg.inmoDocHouse.entity.Rol;
import com.egg.inmoDocHouse.entity.UserEntity;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
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
		String token = jwtTokenProvider.generarToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResponse(token));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Registro registro){
		if(userRepository.existsByUsername(registro.getUsername())) {
			return new ResponseEntity<>("That username already exists",HttpStatus.BAD_REQUEST);
		}
		
		if(userRepository.existsByEmail(registro.getEmail())) {
			return new ResponseEntity<>("That email already exists",HttpStatus.BAD_REQUEST);
		}
		
		UserEntity user = new UserEntity();

		user.setUsername(registro.getUsername());
		user.setEmail(registro.getEmail());
		user.setPassword(passwordEncoder.encode(registro.getPassword()));
		
		Rol roles = rolRepository.findByRolType("ROLE_ADMIN").get();
		user.setRol(Collections.singleton(roles));
		
		userRepository.save(user);
		return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	}
}
