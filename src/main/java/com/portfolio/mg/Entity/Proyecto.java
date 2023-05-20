package com.portfolio.mg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String urlGitHub;
    private String urlImagen;
/*
    @ManyToOne
    private Persona persona;
    public Proyecto() {
    }
*/

    public Proyecto() {
    }
    
    public Proyecto( String nombreProyecto, String urlGitHub, String urlImagen) {
        this.nombreProyecto = nombreProyecto;
        this.urlGitHub = urlGitHub;
        this.urlImagen = urlImagen;
    }
}
