package com.ccprog.demoConcesionario.app.implementacion;

import com.ccprog.demoConcesionario.app.entity.Consecionario;
import com.ccprog.demoConcesionario.app.repositorio.RepositoryConsecionario;
import com.ccprog.demoConcesionario.app.servicio.ConsecionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsecionarioImpl implements ConsecionarioServicio {

    @Autowired
    private RepositoryConsecionario repositoryConsecionario;

    @Override
    public List<Consecionario> findAll(){
        return this.repositoryConsecionario.findAll();
    }

    @Override
    public Consecionario findById(int id) {
        return this.repositoryConsecionario.findAll(id);
    }

    @Override
    public void  actualizarConsecionario(Consecionario consecionario){
        this.repositoryConsecionario.save(consecionario);
    }

    @Override
    public void crearConsecionario (Consecionario consecionario){
        this.repositoryConsecionario.save(consecionario);
    }

    @Override
    public void eliminarConsecionario (int id){

    }
}
