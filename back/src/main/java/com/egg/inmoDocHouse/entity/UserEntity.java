package com.egg.inmoDocHouse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),@UniqueConstraint(columnNames = {"email"})})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String username;
    protected String password;
    protected String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "user_roles", joinColumns =
    @JoinColumn (name="users_id", referencedColumnName="id") , inverseJoinColumns = @JoinColumn (name = "rol_id", referencedColumnName = "id"))
    protected Set<Rol> rol = new HashSet<>();
}
