package com.egg.inmoDocHouse.entity;


import com.egg.inmoDocHouse.auth.entity.Client;
import com.egg.inmoDocHouse.auth.entity.Ente;
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
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffer;


    private int idPropery;

    private int idCliente;

    private int idEnte;

    private String message;

    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMessage;
}
