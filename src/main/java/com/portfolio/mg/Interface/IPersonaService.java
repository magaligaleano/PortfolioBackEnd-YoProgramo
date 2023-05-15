package com.portfolio.mg.Interface;

import com.portfolio.mg.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(long id);
    
    public Persona findPersona(long id);
}
