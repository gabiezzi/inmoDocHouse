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
        Optional<EnteEntity> client = enteRepository.findById(enteEntity.getId());

        if (!client.isPresent()) {
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
        Optional<EnteEntity> enteEntity = enteRepository.findById(id);

        return enteEntity;
    }

    public List<EnteEntity> findAll() {
        List<EnteEntity> listEnte = (enteRepository.findAll());
        return listEnte;
    }

}
