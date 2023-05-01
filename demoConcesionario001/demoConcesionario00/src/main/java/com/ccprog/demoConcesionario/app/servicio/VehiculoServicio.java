package com.ccprog.demoConcesionario.app.servicio;

import com.ccprog.demoConcesionario.app.entity.Vehiculo;

import java.util.List;

public interface VehiculoServicio  {
    public List<Vehiculo> findAll();

    public Vehiculo findById(int id);

    public void actualizarVehiculo (Vehiculo vehiculo);

    public void guardarVehiculo (Vehiculo vehiculo);

    public void eliminarVehiculo(int id);
}
