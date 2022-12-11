package com.egg.inmoDocHouse.service;


import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.entity.ClientEntity;
import com.egg.inmoDocHouse.entity.Property;
import com.egg.inmoDocHouse.repository.AppointmentRepository;
import com.egg.inmoDocHouse.repository.ClientRepository;
import com.egg.inmoDocHouse.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public Appointment save(Appointment appointment) throws Exception {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointment.getIdAppointment());

        if (appointmentOptional.isPresent())
            throw new Exception("There is already an appointment created with that id");


        //if (appointmentRepository.findAppointmentByIdClientAndIdEnte(appointment.getIdClient(),appointment.getIdEnte()).isPresent())
        //  throw new Exception("There is already an appointment created with that Client and Manager");

        appointment.setDateCreation(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment update(Appointment appointmentUpdate) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentUpdate.getIdAppointment());
        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return save(appointmentUpdate);
    }

    @Transactional
    public void delete(int idAppointment) throws Exception {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(idAppointment);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");
        appointmentRepository.deleteById(idAppointment);
    }

    public Optional<Appointment> getAppointment(int id) throws Exception {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        return appointmentOptional;
    }

    public List<Appointment> findAll() throws Exception {
        List<Appointment> listAppointment = appointmentRepository.findAll();

        if (listAppointment.isEmpty()) {
            throw new Exception("There's not appointment yet.");
        }

        return listAppointment;
    }

    public List<Appointment> findAllByClientId(int clientId) throws Exception {
        List<Appointment> listAppointmentClient = appointmentRepository.findAllByClientId(clientId);

        if (listAppointmentClient.isEmpty()) {
            throw new Exception("There's no list for this client.");
        }

        return listAppointmentClient;
    }


    public List<Appointment> findAllByPropertyId(int propertyId) throws Exception {
        List<Appointment> listAppointmentProperty = appointmentRepository.findAllByPropertyId(propertyId);

        if (listAppointmentProperty.isEmpty()) {
            throw new Exception("There's not appointment yet.");
        }

        return listAppointmentProperty;
    }

    public Appointment updateClientProperty(int appointmentId, int clientId, int propertyId) throws Exception {


        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);


        Optional<ClientEntity> optionalClient = clientRepository.findById(clientId);

        Optional<Property> optionalProperty = propertyRepository.findById(propertyId);

        if (!optionalClient.isPresent())
            throw new Exception("There isn't exist a client created with that id");

        if (!optionalProperty.isPresent())
            throw new Exception("There isn't exist a property created with that id");

        if (!appointmentOptional.isPresent())
            throw new Exception("There isn't exist an appointment created with that id");


        appointmentOptional.get().setClient(optionalClient.get());
        appointmentOptional.get().setProperty(optionalProperty.get());

        return appointmentRepository.save(appointmentOptional.get());
    }

    public Appointment addDateAppointment(String dateAppointment, int appointmentId) throws Exception {


        LocalDateTime dateAppointmentFormatted = LocalDateTime.parse(dateAppointment, DateTimeFormatter.ISO_DATE_TIME);

        System.out.println(dayValidator(dateAppointmentFormatted));

        if (dayValidator(dateAppointmentFormatted))


        if (!appointmentRepository.findById(appointmentId).isPresent())
            throw new Exception("There isn't exist an appointment created with that id");

        Appointment appointment = appointmentRepository.findById(appointmentId).get();

        appointment.setDateAppointment(dateAppointmentFormatted);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAppointmentByDateAppointment(int propertyId) throws Exception {
        List<Appointment> listAppointmentProperty = appointmentRepository.findAppointmentByDateAppointment(propertyId);

        if (listAppointmentProperty.isEmpty()) {
            throw new Exception("There's not appointment yet.");
        }

        return listAppointmentProperty;
    }
    
    
    
    public boolean dayValidator(LocalDateTime dateTime) throws Exception {

        LocalTime timeOpen = LocalTime.of(8, 0);
        LocalTime timeClosed = LocalTime.of(19, 0);

        if (dateTime.getDayOfWeek().getValue() == 6 || dateTime.getDayOfWeek().getValue() == 7)
            throw new Exception("Appointment cannot be given on weekend");
        if ( dateTime.toLocalTime().isBefore(timeOpen) || dateTime.toLocalTime().isAfter(timeClosed))
            throw new Exception("It is not possible to make an appointment outside of business hours");
        return true;


    }
    
}
