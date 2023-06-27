
package com.portfolio.mg.Controller;

import com.portfolio.mg.Dto.dtoProyecto;
import com.portfolio.mg.Entity.Proyecto;
import com.portfolio.mg.Security.Controller.Mensaje;
import com.portfolio.mg.Service.SProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://portfolio-frontend-magui.web.app","http://localhost:4200"})
public class ProyectoController {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")    
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
 @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){
        if(StringUtils.isBlank(dtopro.getNombreProyecto())){
             return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyecto.existsByNombreProyecto(dtopro.getNombreProyecto())){
             return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtopro.getNombreProyecto(), dtopro.getUrlGitHub(), dtopro.getUrlImagen());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
@PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody  dtoProyecto dtopro){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sProyecto.existsByNombreProyecto(dtopro.getNombreProyecto()) && sProyecto.getByNombreProyecto(dtopro.getNombreProyecto()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST );
        }          
        if(StringUtils.isBlank(dtopro.getNombreProyecto())){
           return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }         
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreProyecto(dtopro.getNombreProyecto());
        proyecto.setUrlGitHub(dtopro.getUrlGitHub());
        proyecto.setUrlImagen(dtopro.getUrlImagen());
            
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
            
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}

