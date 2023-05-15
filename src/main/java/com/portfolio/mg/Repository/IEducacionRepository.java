package com.portfolio.mg.Repository;

import com.portfolio.mg.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{
    public Optional<Educacion> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
