package com.portfolio.mg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Aptitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String aptitud;
    @NotBlank
    private String aptitudDescripcion;

    /*
    @ManyToOne
    private Persona persona;
 */   
    public Aptitud() {
    }
    
    public Aptitud(String aptitud, String aptitudDescripcion) {
        this.aptitud = aptitud;
        this.aptitudDescripcion = aptitudDescripcion;
    }
     
}
