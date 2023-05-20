package com.portfolio.mg.Controller;

import com.portfolio.mg.Dto.dtoAptitud;
import com.portfolio.mg.Entity.Aptitud;
import com.portfolio.mg.Security.Controller.Mensaje;
import com.portfolio.mg.Service.SAptitud;
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
@RequestMapping("/aptitud")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AptitudController {
    
@Autowired
SAptitud sAptitud;

    @GetMapping("/lista")    
    public ResponseEntity<List<Aptitud>> list(){
        List<Aptitud> list = sAptitud.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
 @GetMapping("/detail/{id}")
    public ResponseEntity<Aptitud> getById(@PathVariable("id")long id){
        if(!sAptitud.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Aptitud aptitud = sAptitud.getOne(id).get();
        return new ResponseEntity(aptitud, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAptitud dtoapt){
        if(StringUtils.isBlank(dtoapt.getAptitud())){
             return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sAptitud.existsByAptitud(dtoapt.getAptitud())){
             return new ResponseEntity(new Mensaje("Esa aptitud ya existe"), HttpStatus.BAD_REQUEST);
        }
        Aptitud aptitud = new Aptitud(dtoapt.getAptitud(), dtoapt.getAptitudDescripcion());
        sAptitud.save(aptitud);
        
        return new ResponseEntity(new Mensaje("Aptitud agregada"), HttpStatus.OK);
    }
    
@PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody  dtoAptitud dtoapt){
        if(!sAptitud.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sAptitud.existsByAptitud(dtoapt.getAptitud()) && sAptitud.getByAptitud(dtoapt.getAptitud()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Esa aptitud ya existe"),HttpStatus.BAD_REQUEST );
        }          
        if(StringUtils.isBlank(dtoapt.getAptitud())){
           return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }         
        
        Aptitud aptitud = sAptitud.getOne(id).get();
        aptitud.setAptitud(dtoapt.getAptitud());
        aptitud.setAptitudDescripcion(dtoapt.getAptitudDescripcion());
       
            
        sAptitud.save(aptitud);
        return new ResponseEntity(new Mensaje("Aptitud actualizada"), HttpStatus.OK);
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if(!sAptitud.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
            
        sAptitud.delete(id);
        return new ResponseEntity(new Mensaje("Aptitud eliminada"), HttpStatus.OK);
    }
}
