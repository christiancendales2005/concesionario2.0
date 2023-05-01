package com.ccprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class VehiculoDto {

    private int id_vehiculo;
    private int id_consecionario;
    private String matricula;
    private String marca;
    private int anio;
    private String color;
    private int kilometros;
    private int puertas;
    private String tipodecarro;
    private int precio;
}
