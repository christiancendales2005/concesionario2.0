package com.ccprog.demoConcesionario.app.controlador;

import com.ccprog.demoConcesionario.app.dto.UsuarioDto;
import com.ccprog.demoConcesionario.app.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UsuarioController {

    @Autowired
    UsuarioNegocio usuarioNegocio;



    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        List<UsuarioDto> listDto=this.usuarioNegocio.findAll();
        Map<String, Object> res=new HashMap<>();
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data",listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearUsuario(@RequestBody Map<String,Object> request){
        Map<String, Object> res=new HashMap<String,Object>();
        System.out.println("@@@@@@"+request.toString());
        UsuarioDto usuarioDto=new UsuarioDto();

        usuarioDto.setId_usuario(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setContrasenia(request.get("contrasenia").toString());
        usuarioDto.setEdad(Integer.parseInt(request.get("edad").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());




        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarUsuario(@RequestBody Map<String,Object> request){
        Map<String, Object> res=new HashMap<String,Object>();

        System.out.println("@@@@"+request.toString());
        UsuarioDto usuarioDto=new UsuarioDto();

        usuarioDto.setId_usuario(Integer.parseInt(request.get("id_usuario").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setContrasenia(request.get("contrasenia").toString());
        usuarioDto.setEdad(Integer.parseInt(request.get("edad").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());




        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status", HttpStatus.ACCEPTED);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarUsuario(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        String resp=this.usuarioNegocio.eliminar(id);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}



