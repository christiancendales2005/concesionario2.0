package com.ccprog.demoConcesionario.app.repositorio;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.id_usuario=id")
    public Usuario encontrarPorId(int id);
    /*@Query(value = "SELECT p FROM Vehiculo p WHERE p.id_vehiculo=id")
    public Vehiculo findByAll();
    List<Vehiculo>*/
}
