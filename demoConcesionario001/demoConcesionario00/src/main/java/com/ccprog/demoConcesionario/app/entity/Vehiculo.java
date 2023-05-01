package com.ccprog.demoConcesionario.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vehiculo")
@Data
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vehiculo;

    @Column(name = "id_consecionario")
    private int id_consecionario;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "marca")
    private String marca;

    @Column(name = "anio")
    private int anio;

    @Column(name = "color")
    private String color;

    @Column(name = "kilometros")
    private int kilometros;

    @Column(name = "puertas")
    private int puertas;

    @Column(name = "tipodecarro")
    private String tipodecarro;

    @Column(name = "precio")
    private int precio;

    //fk_id_consecionario

    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_vehiculo")
    private List<Venta> Ventas;

    @ManyToOne
    @JoinColumn(name = "fk_id_consecionario")
    private Consecionario fk_id_consecionario;
}
