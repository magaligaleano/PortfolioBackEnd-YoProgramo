package com.portfolio.mg.Repository;

import com.portfolio.mg.Entity.Aptitud;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAptitudRepository extends JpaRepository <Aptitud, Long>{
    public Optional<Aptitud> findByAptitud(String Aptitud);
    public boolean existsByAptitud(String Aptitud);
}
