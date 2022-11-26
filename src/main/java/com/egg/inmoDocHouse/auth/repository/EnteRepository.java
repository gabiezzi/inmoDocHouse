package com.egg.inmoDocHouse.auth.repository;

import com.egg.inmoDocHouse.auth.entity.Ente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnteRepository extends JpaRepository<Ente, Integer> {

    Ente findByUsername(String username);

}
