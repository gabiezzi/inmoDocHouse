package com.egg.inmoDocHouse.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    private String lastName;
    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birth;

    private Long dni;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "appointment-client")
     List<Appointment> appointments;
}
