/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mg.Service;

import com.portfolio.mg.Entity.Proyecto;
import com.portfolio.mg.Repository.IProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    IProyectoRepository rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(long id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
        return rProyecto.findByNombreProyecto(nombreProyecto);
    }
    public void save(Proyecto proyecto){
        rProyecto.save(proyecto);
    }
    public void delete(long id){
        rProyecto.deleteById(id);           
    }
    public boolean existsById(long id){
        return rProyecto.existsById(id);
    }
    public boolean existsByNombreProyecto(String nombreProyecto){
        return rProyecto.existsByNombreProyecto(nombreProyecto);
    }
}
