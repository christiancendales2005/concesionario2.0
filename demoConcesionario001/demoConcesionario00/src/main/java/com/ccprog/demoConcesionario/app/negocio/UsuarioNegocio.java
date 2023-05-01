package com.ccprog.demoConcesionario.app.negocio;

import com.ccprog.demoConcesionario.app.implementacion.UsuarioImpl;
import com.ccprog.demoConcesionario.app.dto.UsuarioDto;
import com.ccprog.demoConcesionario.app.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioNegocio {

    @Autowired
    private UsuarioImpl usuarioImp;


    private List<UsuarioDto> usuarioDtoList;
    public List<UsuarioDto> findAll(){
        usuarioDtoList=new ArrayList<>();
        this.usuarioImp.encontrarTodos().forEach(usuario->{
            UsuarioDto usuarioDto=new UsuarioDto();
            usuarioDto.setId_usuario(usuario.getId_usuario());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setContrasenia(usuario.getContrasenia());
            usuarioDto.setEdad(usuario.getEdad());
            usuarioDto.setDireccion(usuario.getDireccion());



            this.usuarioDtoList.add(usuarioDto);
        });

        return this.usuarioDtoList;
    }

    public String guardarUsuario(UsuarioDto usuarioDto){
        Usuario usuario=new Usuario();
        try{
            if(usuarioDto.getId_usuario()!=0){
                usuario.setId_usuario(usuarioDto.getId_usuario());
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setContrasenia(usuarioDto.getContrasenia());
                usuario.setEdad(usuarioDto.getEdad());
                usuario.setDireccion(usuarioDto.getDireccion());



                this.usuarioImp.actualizarUsuario(usuario);
            }else {
                //usuario.setId_usuario(usuarioDto.getId_usuario());
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setContrasenia(usuarioDto.getContrasenia());
                usuario.setEdad(usuarioDto.getEdad());
                usuario.setDireccion(usuarioDto.getDireccion());



                this.usuarioImp.crearUsuario(usuario);
            }
            return "Ok";
        }catch (Exception e){
            return "Bad";
        }
    }
}