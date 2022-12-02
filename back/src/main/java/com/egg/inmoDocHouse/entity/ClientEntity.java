package com.egg.inmoDocHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


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
    private String lastName;
    private String lastName;
}
