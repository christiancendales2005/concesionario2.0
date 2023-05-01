package com.ccprog.demoConcesionario.app.repositorio;


import com.ccprog.demoConcesionario.app.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehiculo extends JpaRepository<Vehiculo,Integer> {

    @Query(value = "SELECT v FROM Vehiculo v WHERE v.id_vehiculo=id")
    public Vehiculo findById(int id);
}
