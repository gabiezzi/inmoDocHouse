package com.egg.inmoDocHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private int idProperty;
    private int idCliente;
    private int idEnte;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAppointment;

    private boolean status;




}
