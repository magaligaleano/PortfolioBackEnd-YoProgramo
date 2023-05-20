package com.portfolio.mg.Service;

import com.portfolio.mg.Entity.Educacion;
import com.portfolio.mg.Repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    IEducacionRepository rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(long id){
        return rEducacion.findById(id);
    }
    public Optional<Educacion> getByTitulo(String titulo){
        return rEducacion.findByTitulo(titulo);
    }
    public void save(Educacion edu){
        rEducacion.save(edu);
    }
    public void delete(long id){
        rEducacion.deleteById(id);
    }
    public boolean existsById(long id){
        return rEducacion.existsById(id);
    }
    public boolean existsByTitulo(String titulo){
        return rEducacion.existsByTitulo(titulo);
    }
}
