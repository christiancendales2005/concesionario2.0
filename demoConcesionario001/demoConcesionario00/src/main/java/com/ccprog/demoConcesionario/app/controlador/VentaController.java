package com.ccprog.demoConcesionario.app.controlador;

import com.ccprog.demoConcesionario.app.dto.VentaDto;
import com.ccprog.demoConcesionario.app.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/venta")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class VentaController {

    @Autowired
    VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all(){
        List<VentaDto> listDto=this.ventaNegocio.findAll();
        Map<String,Object> res=new HashMap<>();
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVenta(@RequestBody Map<String,Object> request){
        Map<String, Object> res=new HashMap<String,Object>();

        System.out.println("@@@@@@"+request.toString());
        VentaDto ventaDto=new VentaDto();

        ventaDto.setId_venta(0);
        ventaDto.setFecha_ventas(new Date());
        ventaDto.setMonto_ventas(Integer.parseInt((request.get("monto_ventas").toString())));

        String respuesta=this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status", HttpStatus.CREATED);
        res.put("Data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
/*
   @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarUsuario(@RequestBody Map<String,Object> request){
        Map<String, Object> res=new HashMap<String,Object>();

        System.out.println("@@@@"+request.toString());
        VentaDto ventaDto=new VentaDto();

        ventaDto.setId_venta(Integer.parseInt(request.get("id_venta").toString()));
        ventaDto.setFecha_ventas(Integer.parseInt(request.get("id_cliente").toString()));
        ventaDto.setId_vehiculo(Integer.parseInt(request.get("id_vehiculo").toString()));

        String respuesta=this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status", HttpStatus.ACCEPTED);
        res.put("Data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    */

}
