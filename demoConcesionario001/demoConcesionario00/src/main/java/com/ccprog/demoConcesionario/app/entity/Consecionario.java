package com.ccprog.demoConcesionario.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "consecionario")
@Data
public class Consecionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_consecionario;

    @Column(name = "nombre_consecionario")
    private String nombre_consecionario;

    @Column(name = "nit_consecionario")
    private int nit_consecionario;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private int telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_consecionario")
    private List<Vehiculo> Vehiculos;

}
