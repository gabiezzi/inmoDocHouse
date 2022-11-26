package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.repository.AppointmentRepository;
import com.egg.inmoDocHouse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PropertyRepository propertyRepository;


    @Transactional
    public Appointment save(Appointment appointment, int idProperty, int idEnte, int idClient) throws Exception {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getIdAppointment());

        if (appointmentOptional.isPresent())
            throw new Exception("There is already an appointment created with that id");

        appointment.setIdClient(idClient);
        appointment.setIdEnte(idEnte);
        appointment.setIdProperty(idProperty);
        appointment.setDateCreation(new Date());

        return appointment;
    }

    @Transactional
    public Appointment update(Appointment appointmentUpdate) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentUpdate.getIdAppointment());
        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return appointmentUpdate;
    }

    @Transactional
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }

    public Optional<Appointment> getAppointment(int id) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return appointmentOptional;
    }

    public Optional<Appointment> getAppointmentByDateAppointment(Date dateAppointment) throws Exception {
         Optional<Appointment> appointmentOptional = appointmentRepository.findByDateAppointment(dateAppointment);


        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that date");

         return appointmentOptional;
    }

    public Optional<Appointment> getAppointmentByClient(int idClient) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findByClient(idClient);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that idClient");

        return appointmentOptional;
    }
}
