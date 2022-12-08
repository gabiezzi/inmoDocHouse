package com.egg.inmoDocHouse.controller;

import com.egg.inmoDocHouse.entity.EnteEntity;
import com.egg.inmoDocHouse.service.EnteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ente")
@CrossOrigin(origins = "http://localhost:5173")
public class EnteController {

    @Autowired
    EnteService enteService;


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if (id == 0) {
            return ResponseEntity.notFound().build();
        }
        enteService.delete(id);
        return ResponseEntity.ok("Complete");
    }


    @PostMapping("/save")
    public ResponseEntity<EnteEntity> save(@RequestBody EnteEntity enteEntity) throws Exception {
        if (enteEntity.equals(null)) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(enteService.save(enteEntity));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EnteEntity> update(@RequestBody EnteEntity updateEnte) throws Exception {
        if (updateEnte.equals(null)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(enteService.update(updateEnte));
        }
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<EnteEntity>> findAll() throws Exception {
        return ResponseEntity.ok(enteService.findAll());
    }


    @GetMapping("/getOne/{enteId}")
    public ResponseEntity<EnteEntity>findByEnteId(@PathVariable("enteId") int enteId) throws Exception {



        EnteEntity enteEntity = enteService.findById(enteId).orElse(null);

        System.out.println(enteEntity.getUsername());

        if(enteEntity.equals(null)) {
            return ResponseEntity.noContent().build();
        }


        return new ResponseEntity<>( enteEntity , HttpStatus.OK);
    }
}
