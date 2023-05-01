package com.ccprog.demoConcesionario.app.servicio;

import com.ccprog.demoConcesionario.app.entity.Venta;

import java.util.List;

public interface VentaServicio {
    public List<Venta> findAll();

    public Venta findById(int id);

    public void actualizarVenta (Venta venta);

    public void crearVenta (Venta venta);

    public void eliminarVenta (int id);
}
