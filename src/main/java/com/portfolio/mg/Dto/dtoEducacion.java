
package com.portfolio.mg.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String instituto;
    @NotBlank
    private String titulo;
    private boolean enCurso;
    private String cursando;
    private String fechaInicio;
    private String fechaFin;

    public dtoEducacion() {
    }

    public dtoEducacion(String instituto, String titulo, boolean enCurso, String cursando, String fechaInicio, String fechaFin) {
        this.instituto = instituto;
        this.titulo = titulo;
        this.cursando = cursando;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    
}
}

