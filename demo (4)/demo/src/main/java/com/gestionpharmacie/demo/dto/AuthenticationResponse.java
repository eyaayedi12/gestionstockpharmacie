package com.gestionpharmacie.demo.dto;

import com.gestionpharmacie.demo.enums.userRole;
import lombok.Data;

@Data
public class AuthenticationResponse {


        private String jwt ;

        private userRole userRole ;

        private Long userId ;

}
