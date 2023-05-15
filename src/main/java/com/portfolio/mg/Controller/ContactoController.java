package com.portfolio.mg.Controller;

import com.portfolio.mg.Dto.dtoContacto;
import com.portfolio.mg.Entity.Contacto;
import com.portfolio.mg.Security.Controller.Mensaje;
import com.portfolio.mg.Service.SContacto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ContactoController {
    @Autowired
    SContacto sContacto;
    
        @GetMapping("/lista")    
    public ResponseEntity<List<Contacto>> list(){
        List<Contacto> list = sContacto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
 @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id")long id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Contacto contacto = sContacto.getOne(id).get();
        return new ResponseEntity(contacto, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtocon){
        
        Contacto contacto = new Contacto(dtocon.getInstagram(), dtocon.getLinkedin(), dtocon.getEmail(), dtocon.getGithub());
        sContacto.save(contacto);
        
        return new ResponseEntity(new Mensaje("Contacto agregado"), HttpStatus.OK);
    }
    
@PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody  dtoContacto dtocon){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }     
        
        Contacto contacto = sContacto.getOne(id).get();
        contacto.setInstagram(dtocon.getInstagram());
        contacto.setLinkedin(dtocon.getLinkedin());
        contacto.setEmail(dtocon.getEmail());
        contacto.setGithub(dtocon.getGithub());
       
            
        sContacto.save(contacto);
        return new ResponseEntity(new Mensaje("Contacto actualizado"), HttpStatus.OK);
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if(!sContacto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
            
        sContacto.delete(id);
        return new ResponseEntity(new Mensaje("Contacto eliminado"), HttpStatus.OK);
    }
}

