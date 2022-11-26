package com.egg.inmoDocHouse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ofert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Property idPropery;

    @OneToOne
    private Client idCliente;

    @OneToOne
    private Ente idEnte;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMessage;
}
