package com.egg.inmoDocHouse.service;

import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.entity.Property;
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

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EnteRepository enteRepository;

    @Transactional
    public Appointment save(int idProperty, int idEnte, int idClient) {
        Appointment appointment = new Appointment();
        Optional<Appointment> appointmentEnte = enteRepository.findById(idEnte);
        Optional<Appointment> appointmentClient = clientRepository.findById(idClient);
        Optional<Property> appointmentProperty = propertyRepository.findById(idProperty);


        appointmentRepository.save(appointmentEnte);
        appointmentRepository.save(appointmentClient);
        appointmentRepository.save(appointmentProperty);
        appointmentRepository.save(appointment);

        return appointment;
    }

    @Transactional
    public Appointment update(Appointment appointmentUpdate) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentUpdate.getIdAppointment());
        appointmentRepository.save(appointmentUpdate);

        return appointmentUpdate;
    }

    @Transactional
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }

    public Optional<Appointment> getAppointment(int id) {
        Optional<Appointment> getAppointment = appointmentRepository.findById(id);

        return getAppointment;
    }

    public Optional<Appointment> getAppointmentByDateAppointment(Date dateAppointment) {
         Optional<Appointment> appointment = appointmentRepository.findByDateAppointment(dateAppointment);
         return appointment;
    }

    public Optional<Appointment> getAppointmentByClient(int idClient) {
        Optional<Appointment> appointmentClient = appointmentRepository.findByClient(idClient);

        return appointmentClient;
    }
}
