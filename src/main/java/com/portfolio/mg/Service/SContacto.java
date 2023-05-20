
package com.portfolio.mg.Service;


import com.portfolio.mg.Entity.Contacto;
import com.portfolio.mg.Repository.IContactoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacto {
    @Autowired
    IContactoRepository rContacto;
    
    public List<Contacto> list(){
        return rContacto.findAll();
    }
    
    public Optional<Contacto> getOne(long id){
        return rContacto.findById(id);
    }
    public void save(Contacto contacto){
        rContacto.save(contacto);
    }
    public void delete(long id){
        rContacto.deleteById(id);           
    }
    public boolean existsById(long id){
        return rContacto.existsById(id);
    }
}
