package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.entity.Offer;
import com.egg.inmoDocHouse.repository.OfferRepository;
import com.egg.inmoDocHouse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    PropertyRepository propertyRepository;


    @Transactional
    public Offer save(Offer offer, int idProperty, int idEnte, int idClient) throws Exception {

        Optional<Offer> offerOptional = offerRepository.findById(offer.getIdOffer());

        if (offerOptional.isPresent())
            throw new Exception("There is already an offer created with that id");

        offer.setIdClient(idClient);
        offer.setIdEnte(idEnte);
        offer.setIdPropery(idProperty);

        return offer;
    }

    @Transactional
    public Offer update(Offer offer) throws Exception {

        Optional<Offer> offerOptional = offerRepository.findById(offer.getIdOffer());

        if (!offerOptional.isPresent())
            throw new Exception("There isn´t an offer created with that id");

        offerRepository.save(offer);

        return offer;
    }


    @Transactional
    public void delete(int id) {
        offerRepository.deleteById(id);
    }


    public Optional<Offer> findByIdClient(int idClient) throws Exception {

        Optional<Offer> offerOptional = offerRepository.findById(idClient);

        if (!offerOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return offerOptional;
    }


    public Optional<Offer> findByIdEnte(int idEnte) throws Exception {

        Optional<Offer> offerOptional = offerRepository.findById(idEnte);

        if (!offerOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return offerOptional;
    }




}
