package com.egg.inmoDocHouse.controller;

import com.egg.inmoDocHouse.entity.Appointment;
import com.egg.inmoDocHouse.repository.AppointmentRepository;
import com.egg.inmoDocHouse.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) throws Exception{

        if (appointment.equals(null)){
            ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointmentService.save(appointment));
    }


}
