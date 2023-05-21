package com.ccprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConsecionarioDto {

    private int id_consecionario;
    private String nombre_consecionario;
    private int nit_consecionario;
    private String direccion;
    private int telefono;

}
