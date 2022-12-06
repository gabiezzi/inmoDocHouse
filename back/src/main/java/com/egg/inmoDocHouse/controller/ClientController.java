package com.egg.inmoDocHouse.controller;


import com.egg.inmoDocHouse.entity.ClientEntity;
import com.egg.inmoDocHouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if(id == 0) {
            return ResponseEntity.notFound().build();
        }
        clientService.delete(id);
        return ResponseEntity.ok("Complete");
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity clientEntity) throws Exception {
        if (clientEntity.equals(null)) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientService.save(clientEntity));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientEntity> update(@RequestBody ClientEntity clientEntity) throws Exception {
        if(clientEntity.equals(null)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clientService.update(clientEntity));
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<ClientEntity>> findAll() throws Exception {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/getOne/{clientId}")
    public ResponseEntity<ClientEntity>findByUserId(@PathVariable("clientId") int clientId) throws Exception {

        System.out.println(clientId);

        ClientEntity clientEntity = clientService.findById(clientId).orElse(null);

        System.out.println(clientEntity.getUsername());

        if(clientEntity.equals(null)) {
            return ResponseEntity.noContent().build();
        }


        return new ResponseEntity<>( clientEntity , HttpStatus.OK);
    }


}
