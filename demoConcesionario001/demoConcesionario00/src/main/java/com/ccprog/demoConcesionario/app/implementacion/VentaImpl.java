package com.ccprog.demoConcesionario.app.implementacion;

import com.ccprog.demoConcesionario.app.entity.Venta;
import com.ccprog.demoConcesionario.app.repositorio.RepositoryVenta;
import com.ccprog.demoConcesionario.app.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {

    @Autowired
    private RepositoryVenta repositoryVenta;

    @Override
    public List<Venta> findAll() {
        return this.repositoryVenta.findAll();
    }

    @Override
    public Venta findById(int id) {
        return this.repositoryVenta.findById(id);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void crearVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void eliminarVenta(int id) {

    }
}
