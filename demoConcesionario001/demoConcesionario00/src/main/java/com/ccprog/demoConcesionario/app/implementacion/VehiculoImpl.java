package com.ccprog.demoConcesionario.app.implementacion;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import com.ccprog.demoConcesionario.app.entity.Vehiculo;
import com.ccprog.demoConcesionario.app.repositorio.RepositoryVehiculo;
import com.ccprog.demoConcesionario.app.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {

    @Autowired
    private RepositoryVehiculo repositoryVehiculo;

    @Override
    public List<Vehiculo> findAll() {
        return  this.repositoryVehiculo.findAll();
    }

    @Override
    public Vehiculo findById (int id){
        return this.repositoryVehiculo.findById(id);
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void guardarVehiculo (Vehiculo vehiculo) {
        this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(int id){
        System.out.println("######"+id);
        Vehiculo vehiculo = this.repositoryVehiculo.getById(id);
        System.out.println("@@@@@@ "+vehiculo.toString());
        if (vehiculo != null){
            this.repositoryVehiculo.delete(vehiculo);
        }
    }

}
