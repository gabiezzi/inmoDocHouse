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

public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffer;

    private int idPropery;

    private int idClient;

    private int idEnte;

    private double priceOffer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMessage;
}
