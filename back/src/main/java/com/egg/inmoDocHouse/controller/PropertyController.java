package com.egg.inmoDocHouse.controller;


import com.egg.inmoDocHouse.entity.Property;
import com.egg.inmoDocHouse.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/property")
@CrossOrigin
public class PropertyController {

    @Autowired
    PropertyService propertyService;


    @GetMapping("/{id}")
    public ResponseEntity<Property> findById(@PathVariable("id") int id) {
        if(id == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findById(id));
    }


    @GetMapping("/m2/{m2}")
    public ResponseEntity<List<Property>> findByM2(@PathVariable("m2") double m2) {
        if(m2 == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByM2(m2));
    }


    @GetMapping("/ambiences/{quantityOfAmbiences}")
    public ResponseEntity<List<Property>> findByQuantityOfAmbiences(@PathVariable("quantityOfAmbiences") int quantityOfAmbiences) {
        if(quantityOfAmbiences == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByQuantityOfAmbiences(quantityOfAmbiences));
    }

    @GetMapping("/pricemin/{price}") //CAMBIE EL PARAMETRO ESPERADO DE PRICEMIN A PRICE
    public ResponseEntity<List<Property>> findByPriceLessThanEquals(@PathVariable("price") double price) {
        if(price == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByPriceLessThanEquals(price));
    }


    @GetMapping("/pricemax/{price}") //CAMBIE EL PARAMETRO ESPERADO DE PRICEMAX A PRICE
    public ResponseEntity<List<Property>> findByPriceGreaterThanEquals(@PathVariable("price") double price) {
        if(price == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByPriceGreaterThanEquals(price));
    }


    @GetMapping("/bathrooms/{quantity}")
    public ResponseEntity<List<Property>> findByQuantityOfBathrooms(@PathVariable("quantity") int quantity) {
        if(quantity == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByQuantityOfBathrooms(quantity));
    }


    @GetMapping("/garage/{garage}")
    public ResponseEntity<List<Property>> findByGarage(@PathVariable("garage") boolean garage) {

        return ResponseEntity.ok(propertyService.findByGarage(garage));
    }


    @GetMapping("/privateNeighborhood/{privateNeighborhood}")
    public ResponseEntity<List<Property>> findByPrivateNeighborhood(@PathVariable("privateNeighborhood") boolean privateNeighborhood) {

        return ResponseEntity.ok(propertyService.findByPrivateNeighborhood(privateNeighborhood));
    }


    @GetMapping("/typeoperation/{typeOperation}")
    public ResponseEntity<List<Property>> findByTypeOperation(@PathVariable("typeOperation") String typeOperation) {
        if(typeOperation.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.findByTypeOperation(typeOperation));
    }


    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Property>> findByUserId(@PathVariable("userId") int userId) {
        if(userId == 0) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<List<Property>>( propertyService.findByUserId(userId), HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Property>> findAll() {
        return ResponseEntity.ok(propertyService.findAll());
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if(id == 0) {
            return ResponseEntity.notFound().build();
        }
        propertyService.delete(id);
        return ResponseEntity.ok("Complete");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Property> save(@RequestBody Property property) {
        if (property.equals(null)) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propertyService.save(property));
    }

    @GetMapping("/ubication/{ubication}")
    public ResponseEntity<List<Property>> findByUbication(@PathVariable("ubication") String ubication) {
        if(ubication.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(propertyService.findByUbication(ubication));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Property> update(@RequestBody Property updateProperty, @PathVariable("id") int id) {
        if(updateProperty.equals(null) || id == 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(propertyService.update(updateProperty, id));
        }
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<Property>> searchFiltersBar(
            @RequestParam(name = "ubication",required = false) String ubication,
            @RequestParam(name= "typeOperation",required = false) String typeOperation,
            @RequestParam(name= "quantity",required = false,defaultValue = "0") int quantity){
        return ResponseEntity.ok(propertyService.searchWithFilters(ubication,typeOperation,quantity));

    }

}
