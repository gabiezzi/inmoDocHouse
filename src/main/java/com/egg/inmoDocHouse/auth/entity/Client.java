package com.egg.inmoDocHouse.auth.entity;

import com.egg.inmoDocHouse.auth.entity.User;
import com.egg.inmoDocHouse.auth.enumerations.Role;
import com.egg.inmoDocHouse.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
public class Client extends User {

   public Client() {
        super();
        this.setRole(Role.CLIENT);
    }
}