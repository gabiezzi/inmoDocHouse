package com.egg.inmoDocHouse.service;




import com.egg.inmoDocHouse.entity.ClientEntity;
import com.egg.inmoDocHouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ClientEntity save(ClientEntity clientEntity) throws Exception {
        Optional<ClientEntity> client = clientRepository.findById(clientEntity.getId());

        if (!client.isPresent()) {
            clientRepository.save(clientEntity);
        } else {
            throw new Exception("El cliente ya se encuenta creado");
        }

        return clientEntity;
    }

    @Transactional
    public ClientEntity update(ClientEntity clientEntity) throws Exception{
        Optional<ClientEntity> client = clientRepository.findById(clientEntity.getId());

        if (!client.isPresent()) {
            clientRepository.save(clientEntity);
        } else {
            throw new Exception("La id del cliente no es valida");
        }

        return clientEntity;
    }

    @Transactional
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    public Optional<ClientEntity> findById(int id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);

        return clientEntity;
    }

    public List<ClientEntity> findAll() {
        List<ClientEntity> listClient = (clientRepository.findAll());
        return listClient;
    }
}
