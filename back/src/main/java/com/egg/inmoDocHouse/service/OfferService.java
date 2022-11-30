package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.Offer;
import com.egg.inmoDocHouse.repository.OfferRepository;
import com.egg.inmoDocHouse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    PropertyRepository propertyRepository;


    @Transactional
    public Offer save(Offer offer) throws Exception {

        Optional<Offer> offerOptional = offerRepository.findById(offer.getIdOffer());

        if (offerOptional.isPresent())
            throw new Exception("There is already an offer created with that id");


        if (offerRepository.findOfferByIdClientAndAndIdPropery(offer.getIdClient(), offer.getIdPropery()).isPresent()) {
            throw new Exception("The client already has a previous offer for this property");
        }

        return offerRepository.save(offer);
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


//    public Optional<Offer> findByIdClient(int idClient) throws Exception {
//
//        Optional<Offer> offerOptional = offerRepository.findById(idClient);
//
//        if (!offerOptional.isPresent())
//            throw new Exception("There isn't exist an appointment created with that id");
//
//        return offerOptional;
//    }


//    public Optional<Offer> findByIdEnte(int idEnte) throws Exception {
//
//        Optional<Offer> offerOptional = offerRepository.findById(idEnte);
//
//        if (!offerOptional.isPresent())
//            throw new Exception("There isn't exist an appointment created with that id");
//
//        return offerOptional;
//    }


    public List<Offer> findAllOfferByIdPropery(int idProperty) throws Exception {
        List<Offer> offers = offerRepository.findAllOfferByIdPropery(idProperty);

        if (offers.isEmpty()) {
            throw new Exception("There's not offer yet");
        }

        return offers;
    }


    public List<Offer> findOfferByIdEnte(int idEnte) throws Exception{
        List<Offer> offers = offerRepository.findOfferByIdEnte(idEnte);

        if (offers.isEmpty()) {
            throw new Exception("There's not offer yet");
        }

        return offers;
    }

    public List<Offer> findAllOffer() throws Exception {
        List<Offer> offers = offerRepository.findAll();

        if (offers.isEmpty()) {
            throw new Exception("There's not offer yet");
        }

        return offers;
    }

    public List<Offer> findOffersByIdClient(int idClient) throws Exception {
        List<Offer> offers = offerRepository.findOffersByIdClient(idClient);

        if (offers.isEmpty()) {
            throw new Exception("There's not offer yet");
        }

        return offers;
    }



}
