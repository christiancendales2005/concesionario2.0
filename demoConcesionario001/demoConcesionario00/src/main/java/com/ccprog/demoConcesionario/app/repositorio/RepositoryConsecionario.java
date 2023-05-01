package com.ccprog.demoConcesionario.app.repositorio;

import com.ccprog.demoConcesionario.app.entity.Consecionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConsecionario extends JpaRepository<Consecionario,Integer> {

    @Query(value = "SELECT c FROM Consecionario c WHERE c.id_consecionario=id")
    public Consecionario findAll(int id);
}
