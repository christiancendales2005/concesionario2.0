package com.ccprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UsuarioDto {

    private int id_usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private int edad;
    private String direccion;
}
