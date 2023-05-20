/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mg.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class dtoProyecto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String urlGitHub;
    private String urlImagen;

    public dtoProyecto() {
    }
    
    
     public dtoProyecto( String nombreProyecto, String urlGitHub, String urlImagen) {
        this.nombreProyecto = nombreProyecto;
        this.urlGitHub = urlGitHub;
        this.urlImagen = urlImagen;
    }
}

