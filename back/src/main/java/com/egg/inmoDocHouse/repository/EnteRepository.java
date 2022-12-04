package com.egg.inmoDocHouse.repository;


import com.egg.inmoDocHouse.entity.EnteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnteRepository extends JpaRepository<EnteEntity, Integer> {


}
