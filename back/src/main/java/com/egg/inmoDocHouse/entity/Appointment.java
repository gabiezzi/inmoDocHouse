package com.egg.inmoDocHouse.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppointment;

    private LocalDateTime dateCreation;

    private LocalDateTime dateAppointment;

    private boolean status = Boolean.FALSE; //en espera , aprobada

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "appointment-client")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "property-appointment")
    private Property property;


}
