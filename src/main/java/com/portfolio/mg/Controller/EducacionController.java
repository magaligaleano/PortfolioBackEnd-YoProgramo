
package com.portfolio.mg.Controller;

import com.portfolio.mg.Dto.dtoEducacion;
import com.portfolio.mg.Entity.Educacion;
import com.portfolio.mg.Security.Controller.Mensaje;
import com.portfolio.mg.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://portfolio-frontend-magui.web.app","http://localhost:4200"})
public class EducacionController {
    @Autowired 
    SEducacion sEducacion;

@GetMapping("/lista")    
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
 @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getTitulo())){
             return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTitulo(dtoEdu.getTitulo())){
             return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoEdu.getTitulo(), dtoEdu.getInstituto(), dtoEdu.getCursando(), dtoEdu.getFechaInicio(), dtoEdu.getFechaFin());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }
    
@PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoEducacion dtoEdu ){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByTitulo(dtoEdu.getTitulo()) && sEducacion.getByTitulo(dtoEdu.getTitulo()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"),HttpStatus.BAD_REQUEST );
        }          
        if(StringUtils.isBlank(dtoEdu.getTitulo())){
           return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }         
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setTitulo(dtoEdu.getTitulo());
        educacion.setInstituto(dtoEdu.getInstituto());
        educacion.setCursando(dtoEdu.getCursando());
        educacion.setFechaInicio(dtoEdu.getFechaInicio());
        educacion.setFechaFin(dtoEdu.getFechaFin());
            
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
            
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}
