package com.egg.inmoDocHouse.service;


import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.repository.AppointmentRepository;
import com.egg.inmoDocHouse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PropertyRepository propertyRepository;


    @Transactional
    public Appointment save(Appointment appointment) throws Exception {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getIdAppointment());

        if (appointmentOptional.isPresent())
            throw new Exception("There is already an appointment created with that id");

        if (appointmentRepository.findAppointmentByIdClientAndIdEnte(appointment.getIdClient(),appointment.getIdEnte()).isPresent())
            throw new Exception("There is already an appointment created with that Client and Manager");


        appointment.setDateCreation(new Date());

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment update(Appointment appointmentUpdate) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentUpdate.getIdAppointment());
        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return appointmentUpdate;
    }

    @Transactional
    public void delete(int idAppointment) throws Exception  {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(idAppointment);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");
        appointmentRepository.deleteById(idAppointment)   ;
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
        Optional<Appointment> appointmentOptional = appointmentRepository.findByIdClient(idClient);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that idClient");

        return appointmentOptional;
    }

    public List<Appointment> findAll() throws Exception{
        List<Appointment> listAppointment = appointmentRepository.findAll();

        if (listAppointment.isEmpty()){
            throw new Exception("There's not appointment yet.");
        }

        return listAppointment;
    }

    public List<Appointment> findAllByIdEnte(int idEnte) throws Exception{
        List<Appointment> listAppointmentEnte = appointmentRepository.findAllByIdEnte(idEnte);

        if (listAppointmentEnte.isEmpty()){
            throw new Exception("There's not appointment yet.");
        }

        return listAppointmentEnte;
    }

    public List<Appointment> findAllByIdProperty(int idProperty) throws Exception{
        List<Appointment> listAppointmentProperty = appointmentRepository.findAllByIdProperty(idProperty);

        if (listAppointmentProperty.isEmpty()){
            throw new Exception("There's not appointment yet.");
        }

        return listAppointmentProperty;
    }
}
