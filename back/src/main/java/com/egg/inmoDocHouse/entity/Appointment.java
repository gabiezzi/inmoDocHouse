package com.egg.inmoDocHouse.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAppointment;

    private boolean status; //en espera , aprobada

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "appointment-client")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "property-appointment")
    private Property property;

}
