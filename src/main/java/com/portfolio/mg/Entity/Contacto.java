package com.portfolio.mg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String instagram;
    private String linkedin;
    private String email;
    private String github;
/*
    @OneToOne
    private Persona persona;
    public Contacto() {
    }
   */ 

    public Contacto() {
    }
    
    public Contacto(String instagram, String linkedin, String email, String github) {
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.email = email;
        this.github = github;
    }
      
}
