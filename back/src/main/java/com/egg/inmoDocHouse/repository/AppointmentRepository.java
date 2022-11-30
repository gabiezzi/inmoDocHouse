package com.egg.inmoDocHouse.repository;


import com.egg.inmoDocHouse.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> findByDateAppointment(Date dateAppointment);

    Optional<Appointment> findByIdClient(int idClient);

    Optional<Appointment> findAppointmentByIdClientAndIdEnte(int idClient, int idEnte);

    List<Appointment> findAll();

    List<Appointment> findAllByIdEnte(int idEnte);

    List<Appointment> findAllByIdProperty(int idProperty);
}
