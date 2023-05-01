package com.ccprog.demoConcesionario.app.servicio;

import com.ccprog.demoConcesionario.app.entity.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> encontrarTodos();

    public  Usuario encontrarPorId(int id);

    public void actualizarUsuario (Usuario usuario);

    public void crearUsuario(Usuario usuario);

    public void eliminarUsuario(int id);
}
