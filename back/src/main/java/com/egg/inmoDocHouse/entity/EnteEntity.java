package com.egg.inmoDocHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class EnteEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnte;

//    @OneToOne
//    private Offer offerReceived;

    private int idOferta;

    public EnteEntity() {
        super();
        this.userRol = "Ente";
    }
}
