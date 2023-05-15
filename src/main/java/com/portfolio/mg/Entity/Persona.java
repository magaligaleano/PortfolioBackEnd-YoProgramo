package com.portfolio.mg.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nombre;
    private String apellido;
    private String img;
    private String ocupacion;
    @Column(name = "sobre_mi", columnDefinition = "TEXT")
    private String sobreMi;
/*
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educaciones;
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    @OneToMany(mappedBy = "persona")
    private List<Aptitud> aptitudes;
    @OneToOne(mappedBy = "persona")
    private Contacto contacto;
  */  
    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String img, String ocupacion, String sobreMi) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.ocupacion = ocupacion;
        this.sobreMi = sobreMi;
    }
    
}
