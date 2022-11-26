package com.egg.inmoDocHouse.repository;

import com.egg.inmoDocHouse.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertRepository extends JpaRepository<Offer, Integer> {

}
