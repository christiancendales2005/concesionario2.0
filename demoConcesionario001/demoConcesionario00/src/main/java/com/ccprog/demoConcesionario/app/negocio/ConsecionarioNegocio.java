package com.ccprog.demoConcesionario.app.negocio;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import com.ccprog.demoConcesionario.app.implementacion.ConsecionarioImpl;
import com.ccprog.demoConcesionario.app.dto.ConsecionarioDto;
import com.ccprog.demoConcesionario.app.entity.Consecionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsecionarioNegocio {

    @Autowired
    private ConsecionarioImpl consecionarioImp;

    private List<ConsecionarioDto> consecionarioDtoList;
    public List<ConsecionarioDto> findAll(){
        consecionarioDtoList=new ArrayList<>();
        this.consecionarioImp.findAll().forEach(consecionario -> {
            ConsecionarioDto consecionarioDto=new ConsecionarioDto();
            consecionarioDto.setId_consecionario(consecionario.getId_consecionario());
            consecionarioDto.setNombre_consecionario(consecionario.getNombre_consecionario());
            consecionarioDto.setNit_consecionario(consecionario.getNit_consecionario());
            consecionarioDto.setDireccion(consecionario.getDireccion());
            consecionarioDto.setTelefono(consecionario.getTelefono());
            this.consecionarioDtoList.add(consecionarioDto);
        });

        return this.consecionarioDtoList;
    }

    public String guardarConsecionario(ConsecionarioDto consecionarioDto){
        Consecionario consecionario=new Consecionario();
        try{
            if(consecionarioDto.getId_consecionario()!=0){
                consecionario.setId_consecionario(consecionarioDto.getId_consecionario());
                consecionario.setNombre_consecionario(consecionarioDto.getNombre_consecionario());
                consecionario.setNit_consecionario(consecionarioDto.getNit_consecionario());
                consecionario.setDireccion(consecionarioDto.getDireccion());
                consecionario.setTelefono(consecionarioDto.getTelefono());
                this.consecionarioImp.actualizarConsecionario(consecionario);
            }else {
                consecionario.setNombre_consecionario(consecionarioDto.getNombre_consecionario());
                consecionario.setNit_consecionario(consecionarioDto.getNit_consecionario());
                consecionario.setDireccion(consecionarioDto.getDireccion());
                consecionario.setTelefono(consecionarioDto.getTelefono());
                this.consecionarioImp.crearConsecionario(consecionario);
            }
            return "Ok";
        }catch (Exception e){
            return "bad";
        }
    }
    public String eliminar(int id){
        Usuario usuario;
        try{
            this.consecionarioImp.eliminarConsecionario(id);
            return "Eliminacion exitosa";

        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
