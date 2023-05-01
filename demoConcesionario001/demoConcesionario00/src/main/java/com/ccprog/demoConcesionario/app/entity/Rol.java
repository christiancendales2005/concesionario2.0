package com.ccprog.demoConcesionario.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_rol")
    private List<Venta> Ventas;

    @ManyToMany(mappedBy="ListRoles")
    private List<Usuario> usuarioList;
}
