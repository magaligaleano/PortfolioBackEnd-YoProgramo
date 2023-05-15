package com.portfolio.mg.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoAptitud {
    @NotBlank
    private String aptitud;
    @NotBlank
    private String aptitudDescripcion;

   
    public dtoAptitud() {
    }
    
    public dtoAptitud(String aptitud, String aptitudDescripcion) {
        this.aptitud = aptitud;
        this.aptitudDescripcion = aptitudDescripcion;
    }
}
