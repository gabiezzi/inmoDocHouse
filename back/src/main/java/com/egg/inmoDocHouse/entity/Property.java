package com.egg.inmoDocHouse.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double m2;
    @Column(name = "quantity_of_ambiences")
    private int quantityOfAmbiences;
    private double price;
    @Column(name = "quantity_of_bathrooms")
    private int quantityOfBathrooms;
    private boolean garage = Boolean.FALSE;
    private double expense;
    @Column(name = "private_Neighborhood")
    private boolean privateNeighborhood;
    @Column(name = "type_operation")
//    @Enumerated(EnumType.STRING)
    private String typeOperation;
    private String ubication;
    private String address;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference(value = "property-appointment")
    List<Appointment> appointments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "ente-property")
    private EnteEntity ente;

}
