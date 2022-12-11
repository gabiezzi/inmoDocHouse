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

    @Autowired
    private EmailService emailService;

    @Transactional
    public ClientEntity save(ClientEntity clientEntity) throws Exception {
        Optional<ClientEntity> client = clientRepository.findById(clientEntity.getId());

        if (!client.isPresent()) {
            clientRepository.save(clientEntity);
        } else {
            throw new Exception("El cliente ya se encuenta creado");
        }

        emailService.sendWelcomeEmailTo(clientEntity.getUsername(), clientEntity.getEmail());

        return clientEntity;
    }

    @Transactional
    public ClientEntity update(ClientEntity clientEntity) throws Exception{
        Optional<ClientEntity> client = clientRepository.findById(clientEntity.getId());

        if (client.isPresent()) {
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



    public Optional<ClientEntity> findById(int id) throws Exception {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);

        if (!clientEntity.isPresent()) {

            throw new Exception("La id del cliente no es valida");
        }

        return clientEntity;
    }

    public List<ClientEntity> findAll() throws Exception{

        List<ClientEntity> listClient = clientRepository.findAll();

        if (listClient.isEmpty()) {
           throw new Exception("No hay elementos para esta lista: Client");
        }

        return listClient;
    }


}
