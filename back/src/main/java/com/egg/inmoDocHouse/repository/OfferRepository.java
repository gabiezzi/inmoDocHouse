package com.egg.inmoDocHouse.repository;

import com.egg.inmoDocHouse.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

    @Override
    List<Offer> findAll();

    Optional<List<Offer>> findByIdClient(int idClient);

    Optional<List<Offer>> findByIdEnte(int idEnte);
}
