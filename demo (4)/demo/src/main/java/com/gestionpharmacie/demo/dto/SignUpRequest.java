package com.gestionpharmacie.demo.dto;

import lombok.Getter;

@Getter
public class SignUpRequest {

    public void setEmail(String email) {
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email ;
    private String name ;
    private String password ;

}
