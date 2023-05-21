package com.ccprog.demoConcesionario.app.negocio;

import com.ccprog.demoConcesionario.app.entity.Usuario;
import com.ccprog.demoConcesionario.app.implementacion.VentaImpl;
import com.ccprog.demoConcesionario.app.dto.VentaDto;
import com.ccprog.demoConcesionario.app.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    private VentaImpl ventaImp;

    private List<VentaDto> ventaDtoList;

    public List<VentaDto> findAll(){
        ventaDtoList=new ArrayList<>();
        this.ventaImp.findAll().forEach(venta -> {
            VentaDto ventaDto=new VentaDto();
            ventaDto.setId_venta(venta.getId_venta());
            ventaDto.setFecha_ventas(venta.getFecha_ventas());
            ventaDto.setMonto_ventas(venta.getMonto_ventas());
            this.ventaDtoList.add(ventaDto);
        });
        return this.ventaDtoList;
    }

    public String guardarVenta(VentaDto ventaDto){
        Venta venta=new Venta();
        try{
            if (ventaDto.getId_venta()!=0){
                venta.setId_venta(venta.getId_venta());
                venta.setFecha_ventas(ventaDto.getFecha_ventas());
                venta.setMonto_ventas(ventaDto.getMonto_ventas());
                this.ventaImp.actualizarVenta(venta);
            }else {
                venta.setFecha_ventas(ventaDto.getFecha_ventas());
                venta.setMonto_ventas(ventaDto.getMonto_ventas());
                this.ventaImp.crearVenta(venta);
            }
            return "Ok";
        }catch (Exception e){
            return "bad";
        }
    }
    public String eliminar(int id){
        Usuario usuario;
        try{
            this.ventaImp.eliminarVenta(id);
            return "Eliminacion exitosa";

        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
