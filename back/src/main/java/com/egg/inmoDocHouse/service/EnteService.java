package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.EnteEntity;
import com.egg.inmoDocHouse.repository.EnteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnteService {

    @Autowired
    EnteRepository enteRepository;


    @Transactional
    public EnteEntity save(EnteEntity enteEntity) throws Exception {
        Optional<EnteEntity> ente = enteRepository.findById(enteEntity.getId());

        if (!ente.isPresent()) {
            enteRepository.save(enteEntity);
        } else {
            throw new Exception("El ente ya se encuenta creado");
        }

        return enteEntity;
    }

    @Transactional
    public EnteEntity update(EnteEntity enteEntity) throws Exception{
        Optional<EnteEntity> ente = enteRepository.findById(enteEntity.getId());

        if (ente.isPresent()) {
            enteRepository.save(enteEntity);
        } else {
            throw new Exception("La id del ente no es valida");
        }

        return enteEntity;
    }

    @Transactional
    public void delete(int id) {
        enteRepository.deleteById(id);
    }

    public Optional<EnteEntity> findById(int id) {
        Optional<EnteEntity> enteOptional = enteRepository.findById(id);

        if (!enteOptional.isPresent()) {
            throw new Exception("La id de la inmobiliaria/dueño no es valida");
        }

        return enteEntity;
    }

    public List<EnteEntity> findAll() {
        List<EnteEntity> listEnte = (enteRepository.findAll());

        if (!listEnte.isPresent()) {
            throw new Exception("La lista no devuelve valores: Inmobiliarias / dueños");
        }
        return listEnte;
    }

}
