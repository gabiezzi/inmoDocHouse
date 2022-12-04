package com.egg.inmoDocHouse.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnteEntity extends UserEntity{


    private String name;

    @OneToMany(mappedBy = "ente", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ente-property")
    List<Property> properties;


}
