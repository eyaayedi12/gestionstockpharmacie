package com.gestionpharmacie.demo.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;


    private String password ;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
