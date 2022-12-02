package com.egg.inmoDocHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity extends UserEntity {

    private int idOferta;
    private String lastName;
    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birth;

    private Long dni;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ClientEntity")
    private List<Appointment> appointment;
}
