package com.portfolio.mg.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoContacto {
    private String instagram;
    private String linkedin;
    private String email;
    private String github;
    
    public dtoContacto() {
    }
    
    public dtoContacto(String instagram, String linkedin, String email, String github) {
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.email = email;
        this.github = github;
    }
}
