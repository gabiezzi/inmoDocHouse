package com.egg.inmoDocHouse.entity;

import lombok.*;

import javax.persistence.*;

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
    private int price;
    @Column(name = "quantity_of_bathrooms")
    private int quantityOfBathrooms;
    private int garage;
    private double expense;
    @Column(name = "private_Neighborhood")
    private boolean privateNeighborhood;
    @Column(name = "type_operation")
    //@Enumerated(EnumType.STRING)
    private String typeOperation;
    private int userId;
    private String ubication;
    private String address;

}
