package com.ccprog.demoConcesionario.app.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "edad")
    private int edad;

    @Column(name = "direccion")
    private String direccion;

    @ManyToMany
    @JoinTable(name = "Usuarios_has_Roles",
            joinColumns = @JoinColumn(name = "Fk_id_Rol", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "Fk_id_usuario",nullable = false))
    private List<Rol> ListRoles;


}