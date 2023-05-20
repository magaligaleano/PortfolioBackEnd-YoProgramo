package com.portfolio.mg.Repository;

import com.portfolio.mg.Entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IContactoRepository extends JpaRepository<Contacto, Long> {
    
}
