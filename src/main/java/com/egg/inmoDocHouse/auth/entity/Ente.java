package com.egg.inmoDocHouse.auth.entity;

import com.egg.inmoDocHouse.auth.entity.User;
import com.egg.inmoDocHouse.auth.enumerations.Role;
import com.egg.inmoDocHouse.entity.Offer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "manager_ente")
public class Ente extends User {

    @OneToOne
    private Offer offer;

    public Ente() {
        super();
        this.setRole(Role.ENTE);
    }
}
