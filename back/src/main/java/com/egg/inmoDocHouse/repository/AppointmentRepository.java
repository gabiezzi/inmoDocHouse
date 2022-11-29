package com.egg.inmoDocHouse.repository;


import com.egg.inmoDocHouse.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> findByDateAppointment(Date dateAppointment);

    Optional<Appointment> findByIdClient(int idClient);
}
