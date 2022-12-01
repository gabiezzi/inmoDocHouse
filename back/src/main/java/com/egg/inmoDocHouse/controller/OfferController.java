package com.egg.inmoDocHouse.controller;

import com.egg.inmoDocHouse.entity.Offer;
import com.egg.inmoDocHouse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
@CrossOrigin
public class OfferController {

    @Autowired
    OfferService offerService;

    @PostMapping("/save")
    public ResponseEntity<Offer> save(@RequestBody Offer offer) throws Exception {
        if (offer.equals(null)) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(offerService.save(offer));
    }

    @PutMapping("/update")
    public ResponseEntity<Offer> update(@RequestBody Offer offer) throws Exception{
        if (offer.equals(null)) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(offerService.update(offer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if (id == 0 ) {
            ResponseEntity.notFound().build();
        }
        offerService.delete(id);

        return ResponseEntity.ok("the offer has been removed");
    }

    @GetMapping("/findAllOfferProperty/{idProperty}")
    public ResponseEntity<List<Offer>> findAllOfferByIdProperty(@PathVariable("idProperty") int idProperty) throws Exception{
        if (idProperty == 0) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(offerService.findAllOfferByIdPropery(idProperty));
    }

    @GetMapping("/findOfferByIdEnte/{idEnte}")
    public ResponseEntity<List<Offer>> findOfferByIdEnte(@PathVariable("idEnte") int idEnte) throws Exception {
        if (idEnte == 0) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(offerService.findOfferByIdEnte(idEnte));
    }

    @GetMapping("/findAllOffer")
    public ResponseEntity<List<Offer>> findAllOffer() throws Exception{
        return ResponseEntity.ok(offerService.findAllOffer());
    }

    @GetMapping("/findOfferByIdClient/{idClient}")
    public ResponseEntity<List<Offer>> findOffersByIdClient(@PathVariable("idClient") int idClient) throws Exception{
        if (idClient == 0 ) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(offerService.findOffersByIdClient(idClient));
    }


}
