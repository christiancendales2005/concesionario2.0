package com.ccprog.demoConcesionario.app.implementacion;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import com.ccprog.demoConcesionario.app.repositorio.RepositoryUsuario;
import com.ccprog.demoConcesionario.app.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioServicio {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public List<Usuario> encontrarTodos() {
        return this.repositoryUsuario.findAll();
    }

    @Override
    public Usuario encontrarPorId(int id) {
        return this.repositoryUsuario.encontrarPorId(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.repositoryUsuario.save(usuario);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.repositoryUsuario.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {

    }
}
