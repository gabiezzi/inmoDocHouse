package com.egg.inmoDocHouse.controller;


import com.egg.inmoDocHouse.entity.ClientEntity;
import com.egg.inmoDocHouse.entity.Property;
import com.egg.inmoDocHouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientEntity>> findAll() throws Exception {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/byclient/{clientId}")
    public ResponseEntity<ClientEntity>findByUserId(@PathVariable("clientId") int clientId) throws Exception {

        ClientEntity clientEntity = clientService.findById(clientId).orElse(null);

        if(clientEntity.equals(null)) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>( clientEntity , HttpStatus.OK);
    }


}
