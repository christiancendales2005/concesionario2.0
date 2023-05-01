package com.ccprog.demoConcesionario.app.controlador;

import com.ccprog.demoConcesionario.app.dto.VehiculoDto;
import com.ccprog.demoConcesionario.app.negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(path = "/vehiculo")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,})
public class VehiculoController {

 @Autowired
 VehiculoNegocio vehiculoNegocio;


 @GetMapping("/all")
 @ResponseBody
 public ResponseEntity<Map<String,Object>> all(){
  List<VehiculoDto> listDto=this.vehiculoNegocio.findAll();
  Map<String, Object> res=new HashMap<>();
  res.put("status", HttpStatus.ACCEPTED);
  res.put("data",listDto);

  return new ResponseEntity<>(res, HttpStatus.OK);
 }
 @PostMapping("/crear")
 @ResponseBody
 public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String,Object> request){
  Map<String,Object> res=new HashMap<String,Object>();

  System.out.println("@@@@@"+request.toString());
  VehiculoDto vehiculoDto = new VehiculoDto();

  vehiculoDto.setId_vehiculo(0);
  vehiculoDto.setId_consecionario(0);
  vehiculoDto.setMatricula(request.get("matricula").toString());
  vehiculoDto.setMarca(request.get("marca").toString());
  vehiculoDto.setAnio(Integer.parseInt(request.get("anio").toString()));
  vehiculoDto.setColor(request.get("color").toString());
  vehiculoDto.setKilometros(Integer.parseInt(request.get("kilometros").toString()));
  vehiculoDto.setPuertas(Integer.parseInt(request.get("puertas").toString()));
  vehiculoDto.setTipodecarro(request.get("tipodecarro").toString());
  vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));

  String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
  res.put("status", HttpStatus.CREATED);
  res.put("data", respuesta);
  return  new ResponseEntity<>(res, HttpStatus.OK);
 }

 @PostMapping("/actualizar")
 @ResponseBody
 public ResponseEntity<Map<String,Object>> actualizarVehiculo(@RequestBody Map<String,Object> request){
  Map<String, Object> res=new HashMap<String,Object>();

  System.out.println("@@@@@"+ request.toString());
  VehiculoDto vehiculoDto=new VehiculoDto();

  vehiculoDto.setId_vehiculo(Integer.parseInt(request.get("id_vehiculo").toString()));
  vehiculoDto.setId_consecionario(Integer.parseInt(request.get("id_consecionario").toString()));
  vehiculoDto.setMatricula(request.get("matricula").toString());
  vehiculoDto.setMarca(request.get("marca").toString());
  vehiculoDto.setAnio(Integer.parseInt(request.get("anio").toString()));
  vehiculoDto.setColor(request.get("color").toString());
  vehiculoDto.setKilometros(Integer.parseInt(request.get("kilometros").toString()));
  vehiculoDto.setPuertas(Integer.parseInt(request.get("puertas").toString()));
  vehiculoDto.setTipodecarro(request.get("tipodecarro").toString());
  vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));

  String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
  res.put("status", HttpStatus.ACCEPTED);
  res.put("data", respuesta);
  return new ResponseEntity<>(res, HttpStatus.OK);
 }
}
