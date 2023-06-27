package com.portfolio.mg.Controller;
import com.portfolio.mg.Entity.Persona;
import com.portfolio.mg.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://portfolio-frontend-magui.web.app","http://localhost:4200"})

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
@GetMapping("/lista")   
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    @GetMapping("/saludar")
    public String Saludar(){
        return "Hola";
    }
    
/*@PreAuthorize("hasRole('ADMIN')")*/
@PostMapping("/crear")
public String createPersona(@RequestBody Persona persona){
    ipersonaService.savePersona(persona);
    return "La persona fue creada correctamente";
}
/*@PreAuthorize("hasRole('ADMIN')")*/
@DeleteMapping ("/borrar/{id}")
public String deletePersona(@PathVariable long id){
    ipersonaService.deletePersona(id);
    return "La persona fue eliminada correctamente";
}
/*@PreAuthorize("hasRole('ADMIN')")*/
@PutMapping("/editar/{id}")
public Persona editPersona(@PathVariable long id,
                           @RequestParam("nombre") String nuevoNombre,
                           @RequestParam("apellido") String nuevoApellido,
                           @RequestParam("img") String nuevaImg,
                           @RequestParam("ocupacion") String nuevaOcupacion,
                           @RequestParam("sobreMi") String nuevoSobreMi){
    Persona persona = ipersonaService.findPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevaImg);
    persona.setOcupacion(nuevaOcupacion);
    persona.setSobreMi(nuevoSobreMi);
    
    ipersonaService.savePersona(persona);
    
    return persona;
}
}
