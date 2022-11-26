package com.egg.inmoDocHouse.auth.repository;

import com.egg.inmoDocHouse.auth.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername (String username);
}
