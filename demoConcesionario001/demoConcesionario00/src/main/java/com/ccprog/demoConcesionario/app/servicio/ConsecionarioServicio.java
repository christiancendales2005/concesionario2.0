package com.ccprog.demoConcesionario.app.servicio;

import com.ccprog.demoConcesionario.app.entity.Consecionario;

import java.util.List;

public interface ConsecionarioServicio {
    public List<Consecionario> findAll();

    public Consecionario findById(int id);

    public void actualizarConsecionario (Consecionario consecionario);

    public void crearConsecionario (Consecionario consecionario);

    public void eliminarConsecionario (int id);
}
