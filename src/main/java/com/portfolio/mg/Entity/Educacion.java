package com.portfolio.mg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String instituto;
    private String titulo;
    private String cursando;
    private String fechaInicio;
    private String fechaFin;
    
    /*
    @ManyToOne
    private Persona persona;
*/
    public Educacion() {
    }

    public Educacion(String instituto, String titulo, String cursando, String fechaInicio, String fechaFin) {
        this.instituto = instituto;
        this.titulo = titulo;
        this.cursando = cursando;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

   
    }

