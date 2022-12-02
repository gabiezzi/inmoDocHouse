package com.egg.inmoDocHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnteEntity extends UserEntity{

    private int idOferta;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "EnteEntity")
    private List<Property> property;
}
