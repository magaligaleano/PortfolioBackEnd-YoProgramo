
package com.portfolio.mg.Repository;
import com.portfolio.mg.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    public Optional<Proyecto> findByNombreProyecto(String nombreProyecto);
    public boolean existsByNombreProyecto(String nombreProyecto);
}
