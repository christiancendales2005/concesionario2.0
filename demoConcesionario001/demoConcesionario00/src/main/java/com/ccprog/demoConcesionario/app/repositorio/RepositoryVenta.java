package com.ccprog.demoConcesionario.app.repositorio;

import com.ccprog.demoConcesionario.app.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVenta extends JpaRepository<Venta,Integer> {

    @Query(value= "SELECT u FROM Venta u WHERE u.id_venta=id")
    public Venta findById(int id);
}
