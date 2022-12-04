package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.UserEntity;
import com.egg.inmoDocHouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity save(UserEntity userEntity) throws Exception {
        Optional<UserEntity> user = userRepository.findById(userEntity.getId());

        if (!user.isPresent()) {
            userRepository.save(userEntity);
        } else {
            throw new Exception("El user ya se encuenta creado");
        }

        return userEntity;
    }

    @Transactional
    public UserEntity update(UserEntity userEntity) throws Exception{
        Optional<UserEntity> user = userRepository.findById(userEntity.getId());

        if (user.isPresent()) {
            userRepository.save(userEntity);
        } else {
            throw new Exception("La id del user no es valida");
        }

        return userEntity;
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> findById(int id) throws Exception {
        Optional<UserEntity> clientEntity = userRepository.findById(id);

        if (!clientEntity.isPresent()) {

            throw new Exception("La id del cliente no es valida");
        }

        return clientEntity;
    }

    public List<UserEntity> findAll() throws Exception{

        List<UserEntity> listUser = userRepository.findAll();

        if (listUser.isEmpty()) {
            throw new Exception("No hay elementos para esta lista: Client");
        }

        return listUser;
    }

}
