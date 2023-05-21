package com.ccprog.demoConcesionario.app.negocio;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import com.ccprog.demoConcesionario.app.implementacion.VehiculoImpl;
import com.ccprog.demoConcesionario.app.dto.VehiculoDto;
import com.ccprog.demoConcesionario.app.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {

    @Autowired
    private VehiculoImpl vehiculoImp;

    private List<VehiculoDto> vehiculoDtoList;

    public List<VehiculoDto> findAll(){
        vehiculoDtoList=new ArrayList<>();
        this.vehiculoImp.findAll().forEach(vehiculo -> {
            VehiculoDto vehiculoDto=new VehiculoDto();
            vehiculoDto.setId_vehiculo(vehiculo.getId_vehiculo());
            vehiculoDto.setId_consecionario(vehiculo.getId_consecionario());
            vehiculoDto.setMatricula(vehiculo.getMatricula());
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setAnio(vehiculo.getAnio());
            vehiculoDto.setColor(vehiculo.getColor());
            vehiculoDto.setKilometros(vehiculo.getKilometros());
            vehiculoDto.setPuertas(vehiculo.getPuertas());
            vehiculoDto.setTipodecarro(vehiculo.getTipodecarro());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            this.vehiculoDtoList.add(vehiculoDto);
        });
        return this.vehiculoDtoList;
    }

    public String guardarVehiculo (VehiculoDto vehiculoDto){
        Vehiculo vehiculo=new Vehiculo();
        try{
           if(vehiculoDto.getId_vehiculo()!=0){
               vehiculo.setId_vehiculo(vehiculoDto.getId_vehiculo());
               vehiculo.setId_consecionario(vehiculoDto.getId_consecionario());
               vehiculo.setMatricula(vehiculoDto.getMatricula());
               vehiculo.setMarca(vehiculoDto.getMarca());
               vehiculo.setAnio(vehiculoDto.getAnio());
               vehiculo.setColor(vehiculoDto.getColor());
               vehiculo.setKilometros(vehiculoDto.getKilometros());
               vehiculo.setPuertas(vehiculoDto.getPuertas());
               vehiculo.setTipodecarro(vehiculoDto.getTipodecarro());
               vehiculo.setPrecio(vehiculoDto.getPrecio());
               this.vehiculoImp.actualizarVehiculo(vehiculo);
            }else {
               vehiculo.setMatricula(vehiculoDto.getMatricula());
               vehiculo.setMarca(vehiculoDto.getMarca());
               vehiculo.setAnio(vehiculoDto.getAnio());
               vehiculo.setColor(vehiculoDto.getColor());
               vehiculo.setKilometros(vehiculoDto.getKilometros());
               vehiculo.setPuertas(vehiculoDto.getPuertas());
               vehiculo.setTipodecarro(vehiculoDto.getTipodecarro());
               vehiculo.setPrecio(vehiculoDto.getPrecio());
               this.vehiculoImp.guardarVehiculo(vehiculo);
           }
           return "Ok";
        }catch (Exception e){
            return "bad";
        }
    }
    public String eliminar(int id){
        Usuario usuario;
        try{
            this.vehiculoImp.eliminarVehiculo(id);
            return "Eliminacion exitosa";

        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
