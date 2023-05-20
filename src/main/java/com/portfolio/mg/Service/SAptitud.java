/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mg.Service;

import com.portfolio.mg.Entity.Aptitud;
import com.portfolio.mg.Repository.IAptitudRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAptitud {
    @Autowired
    IAptitudRepository rAptitud;
    
    public List<Aptitud> list(){
        return rAptitud.findAll();
    }
    
    public Optional<Aptitud> getOne(long id){
        return rAptitud.findById(id);
    }
    
    public Optional<Aptitud> getByAptitud(String nombreProyecto){
        return rAptitud.findByAptitud(nombreProyecto);
    }
    public void save(Aptitud aptitud){
        rAptitud.save(aptitud);
    }
    public void delete(long id){
        rAptitud.deleteById(id);           
    }
    public boolean existsById(long id){
        return rAptitud.existsById(id);
    }
    public boolean existsByAptitud(String aptitud){
        return rAptitud.existsByAptitud(aptitud);
    }
    
}
