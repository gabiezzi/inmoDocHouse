package com.egg.inmoDocHouse.security;

import com.egg.inmoDocHouse.entity.Rol;
import com.egg.inmoDocHouse.entity.UserEntity;
import com.egg.inmoDocHouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (user.equals(null)) {
            throw new UsernameNotFoundException("User : " + usernameOrEmail + " not found");
        }


        return new User(user.getUsername(), user.getPassword(), mapRol(user.getRol()));
    }


    private Collection<? extends GrantedAuthority> mapRol(Set<Rol> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getRolType())).collect(Collectors.toList());
    }

}
