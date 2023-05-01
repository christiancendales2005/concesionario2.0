package com.ccprog.demoConcesionario.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "venta")
@Data
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "fecha_ventas")
    private Date fecha_ventas;

    @Column(name = "monto_venta")
    private int monto_ventas;

    //int fk_id_cliente
    //int fk_id_vehiculo

    @ManyToOne
    @JoinColumn(name = "fk_id_rol")
    private Rol fk_id_rol;

    @ManyToOne
    @JoinColumn(name = "fk_id_vehiculo")
    private Vehiculo fk_id_vehiculo;

}
