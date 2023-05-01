package com.ccprog.demoConcesionario.app.controlador;

import com.ccprog.demoConcesionario.app.dto.ConsecionarioDto;
import com.ccprog.demoConcesionario.app.negocio.ConsecionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/consecionario")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ConsecionarioController {

    @Autowired
    ConsecionarioNegocio consecionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all(){
        List<ConsecionarioDto> ListDto=this.consecionarioNegocio.findAll();
        Map<String,Object> res=new HashMap<>();
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data",ListDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/crear")
    @ResponseBody
    public  ResponseEntity<Map<String, Object>> crearConsecionario(@RequestBody Map<String, Object> request){
        Map<String, Object> res=new HashMap<String, Object>();

        System.out.println("@@@@@@@"+request.toString());
        ConsecionarioDto consecionarioDto=new ConsecionarioDto();

        consecionarioDto.setId_consecionario(0);
        consecionarioDto.setNombre_cosecionario(request.get("nombre_consecionario").toString());
        consecionarioDto.setNit_consecionario(Integer.parseInt(request.get("nit_consecionario").toString()));
        consecionarioDto.setDireccion(request.get("direccion").toString());
        consecionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));

        String respuesta=this.consecionarioNegocio.guardarConsecionario(consecionarioDto);
        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarConsecionario(@RequestBody Map<String, Object> request){
        Map<String, Object> res=new HashMap<String, Object>();

        System.out.println("@@@@@@@"+ request.toString());
        ConsecionarioDto consecionarioDto=new ConsecionarioDto();

        consecionarioDto.setId_consecionario(0);
        consecionarioDto.setNombre_cosecionario(request.get("nombre_consecionario").toString());
        consecionarioDto.setNit_consecionario(Integer.parseInt(request.get("nit_consecionario").toString()));
        consecionarioDto.setDireccion(request.get("direccion").toString());
        consecionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));

        String respuesta=this.consecionarioNegocio.guardarConsecionario(consecionarioDto);
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
