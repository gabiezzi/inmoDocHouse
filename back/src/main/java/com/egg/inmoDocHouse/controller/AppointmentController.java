package com.egg.inmoDocHouse.controller;

import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/appointment/")
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping( "/save" )
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) throws Exception{

        if (appointment.equals(null)){
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @PutMapping("/update")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment) throws Exception{
        if (appointment.equals(null)) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.update(appointment));
    }

    @PutMapping("/updateClientProperty/{appointmentId}")
    public ResponseEntity<Appointment> updateClientProperty(@PathVariable int appointmentId, @RequestParam int clientId, @RequestParam int propertyId) throws Exception{
        if (clientId==0 || appointmentId==0 || propertyId ==0) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.updateClientProperty(appointmentId, clientId , propertyId));
    }

    @DeleteMapping("/delete/{idAppointment}")
    public ResponseEntity<String> delete(@PathVariable("idAppointment") int idAppointment) throws Exception{
        if (idAppointment == 0) {
            ResponseEntity.notFound().build();
        }

        appointmentService.delete(idAppointment);
        return ResponseEntity.ok("Appointment has been deleted");
    }

    @GetMapping("/getAppointment/{id}")
    public ResponseEntity<Optional<Appointment>> getAppointment(@PathVariable("id") int id) throws Exception{
        if (id == 0) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    /* @GetMapping("/getAppointmentByDateAppointment/{dateAppointment}")
    public ResponseEntity<Optional<Appointment>> getAppointmentByDateAppointment(@PathVariable("dateAppointment") Date dateAppointment) throws Exception{
        if (dateAppointment.equals(null)) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointmentService.getAppointmentByDateAppointment(dateAppointment));
    } */


    @GetMapping("/findAll")
    public ResponseEntity<List<Appointment>> findAll() throws Exception{
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping("/findAllByIdClient/{idClient}")
    public ResponseEntity<List<Appointment>> findAllByClientId(@PathVariable("idClient") int idClient) throws Exception{
        if (idClient == 0) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.findAllByClientId(idClient));
    }


    @GetMapping("/findAllByIdProperty/{idProperty}")
    public ResponseEntity<List<Appointment>> findAllByIdProperty(@PathVariable("idProperty") int idProperty) throws Exception{
        if (idProperty == 0) {
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.findAllByPropertyId(idProperty));
    }


}
